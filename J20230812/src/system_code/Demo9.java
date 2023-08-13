package system_code;

/**
 * 线程的打断 - 使用Thread的内部标志位
 */
public class Demo9 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("线程工作中~");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    //1.假装没有听见，循环继续正常执行
                    e.printStackTrace();
                    //2.加上一个break，表示让线程立即结束
                    //break;
                    //3.做一些其他工作，完成工作后在结束
                    break;
                }
            }
        });

        thread.start();

        Thread.sleep(5000);
        System.out.println("让线程thread终止~");
        thread.interrupt();
    }
}
