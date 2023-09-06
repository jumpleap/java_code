package practice;

public class Demo12 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("线程工作中");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    //三种处理方式
                    //1.不管它，让循环继续执行
                    e.printStackTrace();

                    //2.添加break，跳出循环
                    break;

                    //3.在跳出循环之前做一些任务
                }
                System.out.println("线程工作结束");
            }
        });

        //start()方法会在系统内核中创建出线程，线程自动调用run()方法
        thread.start();

        //主线程休眠5秒
        Thread.sleep(5000);
        //把Thread内部的标记位设为true，打断sleep的休眠，引发异常
        thread.interrupt();

    }
}