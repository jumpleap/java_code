package test;

public class Test {
    public static void main(String[] args) {
        MyTimer myTimer = new MyTimer();
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("3000");
            }
        }, 3000);

        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("2000");
            }
        }, 2000);

        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("1000");
            }
        }, 1000);

        System.out.println("任务开始执行!");
    }
}
