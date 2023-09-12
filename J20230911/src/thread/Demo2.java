package thread;

/**
 * 阻塞队列
 */
class MyBlockingQueue {
    private String[] elements;
    //涉及修改的操作需要保证原子性
    private volatile int start;
    private volatile int end;
    private volatile int size;
    //默认大小
    private final static int DEFAULT_LENGTH = 1000;

    public MyBlockingQueue() {
        elements = new String[DEFAULT_LENGTH];
    }

    public void put(String data) throws InterruptedException {
        synchronized (this) {
            //再进行判断一次, 若还是满的, 那么就继续进行阻塞
            while (size == elements.length) {
                //队列满了,还想往里面添加元素,则会导致阻塞
                this.wait();
            }
            //队列没满
            elements[end++] = data;

            //end自增后和数组的长度相同
            if (end == elements.length) {
                //重置
                end = 0;
            }
            //长度自增
            size++;
            //唤醒take中的wait
            this.notify();
        }
    }

    public String take() throws InterruptedException {
        synchronized (this) {
            while (size == 0) {
                //队列为空, 相要继续取元素, 进行阻塞
                this.wait();
            }
            //数组不为空
            String oldValue = elements[start];
            //前移
            start++;
            //start自增到和数组长度一样
            if (start == elements.length) {
                //重置
                start = 0;
            }
            size--;
            //唤醒put中的wait
            this.notify();
            return oldValue;
        }
    }
}

public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
        MyBlockingQueue queue = new MyBlockingQueue();
        //生产者
        Thread t1 = new Thread(() -> {
            int count = 0;
            while (true) {
                try {
                    queue.put(count + "");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("生产者生产了 : " + count);
                count++;
            }
        });

        //消费者
        Thread t2 = new Thread(() -> {
            while (true) {
                try {
                    System.out.println("消费者消费了" + queue.take());
                    //每500ms消费一次
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        //启动生产者和消费者
        t1.start();
        t2.start();
    }
}