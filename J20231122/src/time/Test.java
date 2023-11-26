package time;

public class Test {
    public static void main(String[] args) {
        MyTimer timer = new MyTimer();

        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(3000);
            }
        }, 3000);

        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(2000);
            }
        }, 2000);

        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(1000);
            }
        }, 1000);

        System.out.println("开始执行定时器!");
    }
}
