package thread;

// 线程的创建方式 -- 实现Runnable重写run方法
public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
        //Runnable runnable = new MyRunnable();
        Thread thread = new Thread(new MyRunnable());

        /*Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        })*/
        thread.start();

        while (true) {
            System.out.println("main!");
            Thread.sleep(1000);
        }
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("thread!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}