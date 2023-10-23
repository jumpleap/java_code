package demo;

public class Demo5 {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            int count = i;
            Thread t = new Thread(() -> {
                System.out.print(count + " ");
            });
            t.start();
            t.join();
        }

        System.out.println("\nOK");
    }
}
