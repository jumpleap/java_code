package practice;

public class Demo11 {
    //标记位
    private static boolean isQuit = false;

    public static void main(String[] args) throws InterruptedException {
        //创建线程类
        Thread thread = new Thread(() -> {
            while (!isQuit) {
                System.out.println("线程工作中");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程工作结束");
            }
        });

        //start()方法会在系统内核中创建出线程，线程自动调用run()方法
        thread.start();

        //主线程休眠5秒
        Thread.sleep(5000);
        //给标记位赋值，run()结束
        isQuit = true;
    }
}