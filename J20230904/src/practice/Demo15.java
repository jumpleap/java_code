package practice;

public class Demo15 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("线程工作中");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //获取此时线程的状态
        System.out.println(thread.getState());//NEW

        thread.start();

        ///获取此时线程的状态
        System.out.println(thread.getState());//RUNNABLE

        Thread.sleep(5000);

        //获取此时线程的状态
        System.out.println(thread.getState());//TIMED_WAITING
    }
}