package timer;

import java.util.Timer;
import java.util.TimerTask;

// 定时器的基本使用
public class Demo {
    public static void main(String[] args) {
        // 创建定时器对象
        Timer timer = new Timer();

        // 使用schedule方法来提交任务(需要重写run方法), 和任务的被执行时间
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("3000");
            }
        }, 3000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("2000");
            }
        }, 2000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("3000");
            }
        }, 3000);

        // 任务的执行会在Timer的内部使用一个额外的线程来进行扫描, 一旦被执行的时间到了, 就会被执行
    }
}
