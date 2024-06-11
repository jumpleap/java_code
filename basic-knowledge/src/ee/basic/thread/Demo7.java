package ee.basic.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

// 创建线程 -- Callable
public class Demo7 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // 初始化Callable
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "thread 启动！";
            }
        };

        // FutureTas用于获取callable的结果
        FutureTask<String> futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(futureTask);

        thread.start();
        String result = futureTask.get();
        System.out.println(result);
        Thread.sleep(1000);
        System.out.println("main 启动！");
    }
}