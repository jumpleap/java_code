package test;

import java.util.Timer;
import java.util.TimerTask;

// 标准库中定时器的使用
public class Demo {
    public static void main(String[] args) {
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("任务1");
            }
        }, 1000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("任务2");
            }
        }, 2000);

        System.out.println("开始执行任务!");
    }
}
