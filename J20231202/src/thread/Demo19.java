package thread;

// wait的使用
public class Demo19 {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();

        System.out.println("wait之前");
        synchronized (object) {
            // 要想使用wait必须要加锁
            object.wait(500);
        }
        System.out.println("wait之后");
    }
}
