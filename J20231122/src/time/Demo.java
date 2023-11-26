package time;

import java.util.Timer;
import java.util.TimerTask;

// 定时器的使用
public class Demo {
    public static void main(String[] args) {
        // 创建定时器
        Timer timer = new Timer();

        // 往定时器中添加任务
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("3000");
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

        System.out.println("定时器执行!");
    }
}