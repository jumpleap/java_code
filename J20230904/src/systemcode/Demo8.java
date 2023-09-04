package systemcode;

/**
 * 线程的基本属性
 */
public class Demo8 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            //System.out.println("hello,thread");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        //NEW状态：调用start之前的状态
        System.out.println(t.getState());

        t.start();

        //运行状态
        for (int i = 0; i < 5; i++) {
            System.out.println(t.getState());
            Thread.sleep(1000);
        }

        t.join();
        //线程结束之后的状态：TERMINATED
        System.out.println(t.getState());
    }
}
