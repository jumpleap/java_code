package thread;

/**
 * Thread的方法 -- 线程的打断(自定义属性完成)
 */
public class Demo8 {
    private static boolean isQuit = false;

    public static void main(String[] args) throws InterruptedException {
        //boolean isQuit = false;
        //注: lambda表达式中有一个变量捕获的规则, 局部变量若是在其中,使用局部变量后, 局部变量不能被修改
        Thread t = new Thread(() -> {
            System.out.println("线程开始");
            while (!isQuit) {
                System.out.println("线程工作中");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("线程结束");
        });

        t.start();

        Thread.sleep(5000);
        isQuit = true;
        System.out.println("设置isQuit 为 true");
    }
}
