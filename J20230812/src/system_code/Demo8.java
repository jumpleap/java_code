package system_code;

/**
 * 线程的打断 - 使用成员变量/局部变量
 */
public class Demo8 {
    //private static boolean isQuit = false;

    public static void main(String[] args) throws InterruptedException {
        boolean isQuit = false;
        Thread thread = new Thread(() -> {
            while (!isQuit) {
                System.out.println("线程工作中");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("线程工作完毕！");
        });

        thread.start();
        Thread.sleep(1000);

        //isQuit = true;
        System.out.println("设置isQuit 为 true");
    }
}
