package systemcode;

/**
 * 线程的基本属性
 */
public class Demo7 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            System.out.println("线程开始");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程结束");
        });

        //获取进程的ID，ID是线程的唯一标识，不同的线程ID不同
        System.out.println(t.getId());
        //线程的名字
        System.out.println(t.getName());
        //获取线程的优先级
        System.out.println(t.getPriority());


        //Alive方法 - 当run方法运行结束后返回false
        System.out.println(t.isAlive());
        t.start();

        System.out.println(t.isAlive());
        Thread.sleep(3000);
        System.out.println(t.isAlive());
    }
}