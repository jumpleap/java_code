package practice;

public class Demo5 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println("hello,thread");
                try {
                    //线程休眠1秒
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //调用start方法，系统中创建出线程，线程自动调用run()方法
        thread.start();

        while (true) {
            System.out.println("hello,main");
            Thread.sleep(1000);
        }
    }
}