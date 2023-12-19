package thread;

// 阻塞队列的模拟实现
class MyBlockingQueue {
    private String[] elem = new String[1000];
    // 保证内存可见性
    private volatile int start;
    private volatile int end;
    private volatile int usedSize;

    // 入队列
    public void put(String data) throws InterruptedException {
        // 加锁
        synchronized (this) {
            // 队列满了
            while (usedSize == elem.length) {
                // 进行阻塞等待
                this.wait();
            }

            // 队列没满
            elem[end++] = data;
            // 重置
            if (end == elem.length) {
                end = 0;
            }
            // 队列有效元素个数+1
            usedSize++;
            // 用来唤醒出队列中队列为空的情况
            this.notify();
        }
    }

    // 出队列
    public String take() throws InterruptedException {
        // 加锁
        synchronized (this) {
            // 队列为空
            while (usedSize == 0) {
                // 进行线程阻塞
                this.wait();
            }

            // 队列不为空
            String oldVal = elem[start++];
            // 重置
            if (start == elem.length) {
                start = 0;
            }
            // 队列有效元素个数-1
            usedSize--;
            // 用于唤醒入队列中满的情况
            this.notify();
            return oldVal;
        }
    }
}

public class Demo24 {
    public static void main(String[] args) {
        MyBlockingQueue queue = new MyBlockingQueue();

        // 生产者
        Thread t1 = new Thread(() -> {
            int id = 1;
            while (true) {
                try {
                    System.out.println("生产者生产了: " + id);
                    queue.put(id + "");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                id++;
            }
        });

        // 消费者
        Thread t2 = new Thread(() -> {
            while (true) {
                try {
                    System.out.println("消费者消费了: " + queue.take());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // 启动
        t1.start();
        t2.start();
    }
}
