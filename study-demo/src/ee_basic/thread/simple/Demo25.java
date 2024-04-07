package ee_basic.thread.simple;

/*
    wait()的作用:
        1) 释放当前的锁(前提: 当前已经拥有了锁)
        2) 让线程进行阻塞等待的状态
        3) 当线程被唤醒后, 重新获取到锁
    notify:
        1) notify()唤醒阻塞的线程, 使线程结束阻塞等待的状态
        2) notify()也要使用在synchronized中, notify()用于通知等待的线程, 使他们重新获取该对象的锁
 */
public class Demo25 {
    public static void main(String[] args) {
        Object locker = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (locker) {
                System.out.println("wait之前");
                try {
                    // 释放当前的锁, 进行阻塞等待
                    locker.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("wait之后");
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (locker) {
                System.out.println("进行通知");
                // 唤醒阻塞等待的锁
                locker.notify();
            }
        });

        t1.start();
        t2.start();
    }

    /*
        wait() 和 sleep()的区别:
            1) wait() 是让线程间进行通信的; sleep()是让线程阻塞一段时间
            2) wait()需要搭配synchronized进行使用, sleep()不需要
            3) wait()是Object的方法, sleep是Thread类的静态方法
            4) 两者均让线程放弃一段执行时间
     */
}