package thread.difficult;

import java.util.Timer;
import java.util.TimerTask;

// 定时器的使用
public class Demo5 {
    public static void main(String[] args) {
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(3000);
            }
        }, 3000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(2000);
            }
        }, 2000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(1000);
            }
        }, 1000);

        System.out.println("程序启动");
    }
}
