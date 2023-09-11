package systemcode;

/**
 * 阻塞队列的模拟实现
 */
public class MyBlockingQueue {
    //添加volatile关键字,保证内存可见性
    private volatile int head;
    private volatile int tail;
    private volatile int size;

    private String[] element;
    private final static int DEFAULT_LENGTH = 1000;

    public MyBlockingQueue() {
        element = new String[DEFAULT_LENGTH];
    }

    public void put(String val) throws InterruptedException {
        synchronized (this) {
            while (size == element.length) {
                //队列满了,想继续添加元素,就会阻塞
                this.wait();
            }
            //队列没满,继续往里面添加元素
            element[tail] = val;
            tail++;
            //tail自增之后,到达了数组末尾,让它回到开头
            if (tail == element.length) {
                tail = 0;
            }
            size++;
            //唤醒take()中的wait
            this.notify();
        }
    }

    public String take() throws InterruptedException {
        synchronized (this) {
            while (size == 0) {
                //队列为空,想继续出队,阻塞
                this.wait();
            }
            //队列不为空,继续出队
            String oldVal = element[head];
            head++;
            //若head自增之后到达了数组末尾,这个时候让它回到开头
            if (head == element.length) {
                head = 0;
            }
            size--;
            //唤醒put()中的wait
            this.notify();
            return oldVal;
        }
    }
}

/**
 * 演示生产者和消费者模型
 */

class Demo2 {
    public static void main(String[] args) {
        MyBlockingQueue myBlockingQueue = new MyBlockingQueue();
        //当为生产者
        Thread t1 = new Thread(() -> {
            int num = 0;
            while (true) {
                try {
                    myBlockingQueue.put(num + "");
                    System.out.println("生产者生产了:" + num);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                num++;
            }
        });

        //消费者
        Thread t2 = new Thread(() -> {
            while (true) {
                try {
                    String val = myBlockingQueue.take();
                    Thread.sleep(500);
                    System.out.println("消费者消费了:" + val);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();
    }
}