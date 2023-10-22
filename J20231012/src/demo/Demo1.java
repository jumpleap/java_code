package demo;

public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        /*Runnable runnable = new LiftOff();
        Thread t = new Thread(runnable);

        t.start();
        //t.start();

        Thread t1 = new Thread(runnable);
        t1.start();*/

        Thread t1 = new Thread(new LiftOff());
        t1.start();
        Thread.sleep(1000);

        Thread t2 = new Thread(new LiftOff());
        t2.start();
    }
}


class LiftOff implements Runnable {
    protected int countDown = 10;
    private static int taskCount = 0; //所有类共享资源, 任务编号
    private final int id = taskCount++; //任务id

    public LiftOff() {}

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "id:" + id + ", " + (countDown > 0 ? countDown : "LiftOff!") + " ";
    }

    @Override
    public void run() {
        while(countDown-- > 0) {
            System.out.print(status());
            //让出CPU,可以将CPU从一个线程转移给另一个线程
            Thread.yield();
        }
        System.out.println();
    }
}