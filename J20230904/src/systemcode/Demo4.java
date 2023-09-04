package systemcode;

/**
 * 创建线程的五种方式 - 实现Runnable，重写run，使用匿名内部类
 */
public class Demo4 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("hello,thread");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t.start();

        while (true) {
            System.out.println("hello,main");
            Thread.sleep(1000);
        }
    }
}
