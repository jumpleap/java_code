package thread;


// 阻塞队列的模拟实现
public class MyBlockingQueue {
    // 队列的最大长度
    private String[] data = new String[1000];
    // 队列的起始位置
    private volatile int head;
    // 队列的尾部位置
    private volatile int tail;
    // 队列中元素个数
    private volatile int size;


    // 入队列
    public void put(String elem) throws InterruptedException {
        synchronized (this) {
            while (size == data.length) {
                // 队列满了, 进行阻塞等待
                this.wait();
            }

            // 队列没满, 往数组中添加元素
            this.data[tail++] = elem;

            // 如果tail自增之后到达数组末尾, 需要让tail回到开头
            if (tail == data.length) {
                tail = 0;
            }
            size++;

            // 这个notify用于唤醒take中的wait
            this.notify();
        }
    }

    // 出队列
    public String take() throws InterruptedException {
        synchronized (this) {
            while (size == 0) {
                // 如果队列为空, 那么进行阻塞等待到有元素进来
                this.wait();
            }

            // 拿到当前要出队列的元素
            String oldVal = this.data[head++];

            // 判断head是否已经到了数组末尾
            if (head == data.length) {
                // 到末尾就需要进行重置
                head = 0;
            }
            size--;
            // 用于唤醒put中的wait
            this.notify();
            // 返回出队的元素
            return oldVal;
        }
    }


    public static void main(String[] args) {
        MyBlockingQueue myBlockingQueue = new MyBlockingQueue();

        // t1线程作为生产者
        Thread t1 = new Thread(() -> {
            int count = 0;
            while (true) {
                try {
                    myBlockingQueue.put(count + "");
                    System.out.println("生产者生产了: " + count);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                count++;
            }
        });

        // t2线程作为消费者
        Thread t2 = new Thread(() -> {
            while (true) {
                try {
                    System.out.println("消费者消费了: " + myBlockingQueue.take());
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();
    }
}