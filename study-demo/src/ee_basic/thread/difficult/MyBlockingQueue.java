package ee_basic.thread.difficult;

// 阻塞队列的实现
public class MyBlockingQueue {
    // 定义数组大小
    private String[] elem = new String[1000];
    // 定义头尾
    private volatile int head;
    private volatile int tail;
    // 数组元素个数
    private volatile int size;

    public void put(String data) throws InterruptedException {
        synchronized (this) {
            // 当队列满了的话, 进入阻塞等待, 直到有空间剩余
            while (size == elem.length) {
                this.wait();
            }
            // 队列未满, 往队列尾部添加元素
            elem[tail] = data;
            tail++;
            // 设置为环形队列
            if (tail == elem.length) {
                tail = 0;
            }
            size++;

            // 唤醒当队列为空的情况, 唤醒take中的wait, 此时队列不为空
            this.notify();
        }
    }

    public String take() throws InterruptedException {
        synchronized (this) {
            // 当阻塞队列为空时, 则进行阻塞等待, 直到put中的notify唤醒
            while (size == 0) {
                this.wait();
            }

            String oldVal = elem[head];
            head++;
            // 设置为环形队列
            if (head == elem.length) {
                head = 0;
            }
            size--;
            // 唤醒队列为满的情况, 唤醒put中的wait的情况, 此时队列未满
            this.notify();
            return oldVal;
        }
    }
}


class Demo4 {
    public static void main(String[] args) throws InterruptedException {
        MyBlockingQueue queue = new MyBlockingQueue();

        // t1作为生产者
        Thread t1 = new Thread(() -> {
            int count = 0;
            while (true) {
                try {
                    queue.put(count + "");
                    System.out.println("生产元素:" + count);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count++;
            }
        });

        // t2作为消费者
        Thread t2 = new Thread(() -> {
            while (true) {
                try {
                    System.out.println("消费者消费: " + queue.take());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

    }
}