package practice;

/**
 * isAlive()方法的使用
 */
public class Demo10 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("线程开始工作");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程工作结束");
        });

        //判断线程是否存活,此时，新线程还没有开始创建
        System.out.println(thread.isAlive());//false

        //调用start()方法后，在系统中会创建出一个新线程，线程会自动调用run()方法
        thread.start();
        //此时，线程已经调度了
        System.out.println(thread.isAlive());//true

        Thread.sleep(3000);
        //此时，线程已经运行结束，销毁了
        System.out.println(thread.isAlive());//false
    }
}
