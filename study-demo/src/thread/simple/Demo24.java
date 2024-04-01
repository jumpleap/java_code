package thread.simple;

// wait方法
public class Demo24 {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();


        // 想要使用wait(), 必须给使用wait()的对象加上锁, 否则出现上述异常
//        System.out.println("wait之前");
//        // 把wait要放到synchronized里面调用, 保证确实是拿到锁的
//        object.wait();
//        System.out.println("wait之后");

        synchronized (object) {
            System.out.println("wait之前");
            // 把wait要放到synchronized里面调用, 保证确实是拿到锁的
            object.wait();
            System.out.println("wait之后");
        }
    }
}
