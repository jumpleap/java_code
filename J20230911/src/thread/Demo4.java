package thread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时器的基本使用
 */

public class Demo4 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("3000");
            }
        },3000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("2000");
            }
        }, 2000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("1000");
            }
        }, 1000);
    }
}