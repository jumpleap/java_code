package systemcode;

/**
 * 线程的终止/打断 - Thread自带的标志位
 */
public class Demo10 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            //Thread.currentThread():获取当前线程
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("线程工作中!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    //1.继续执行代码，触发异常后标志位被重置
                    e.printStackTrace();
                    //2.加上break，让循环结束
                    break;
                    //3.做一些其他工作，做完后工作结束
                }
            }
        });

        t.start();

        Thread.sleep(5000);
        System.out.println("让t线程终止！");
        //把标志位设置为true
        t.interrupt();
    }
}