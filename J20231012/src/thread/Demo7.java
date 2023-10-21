package thread;

/**
 * Thread类的属性 -- isAlive()
 */
public class Demo7 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {

            System.out.println("线程开始");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("线程结束");

        });
        //还没有执行到start方法, 线程没创建, false
        System.out.println(t.isAlive());

        t.start();
        //在执行中, 线程存活
        System.out.println(t.isAlive());
        Thread.sleep(3000);
        //线程销毁后, Thread的对象t还在, 但是线程已经被销毁了
        System.out.println(t.isAlive());
    }
}
