package systemcode;

/**
 * 多线程 -- wait的使用
 */
public class Demo8 {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        System.out.println("wait之前");
        //wait方法必须在synchronized中使用,必须先有锁才能释放锁
        object.wait();
        System.out.println("wait之后");
    }
}
