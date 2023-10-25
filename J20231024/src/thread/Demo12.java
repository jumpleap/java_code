package thread;

public class Demo12 {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        System.out.println("wait()之前");
        object.wait();
        System.out.println("wait()之后");
    }
}
