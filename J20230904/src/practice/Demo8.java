package practice;

/**
 * Thread类的常见属性
 */
public class Demo8 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("线程开始工作");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程结束工作");

        });

        //调用start之后，系统中会创建出一个新线程，然后新线程自动调用run()方法
        thread.start();

        //获取线程的ID
        System.out.println(thread.getId());

        //获取线程的名称
        System.out.println(thread.getName());

        //获取线程的优先级
        System.out.println(thread.getPriority());
    }
}