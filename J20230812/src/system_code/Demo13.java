package system_code;

public class Demo13 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //在调用start之前获取状态，此时就散NEW状态
        System.out.println(thread.getState());
        thread.start();

        for (int i = 0; i < 5; i++) {
            System.out.println(thread.getState());
            Thread.sleep(1000);
        }

        thread.join();
        //在线程结束之后，获取线程的状态，此时是TERMINATED状态
        System.out.println(thread.getState());
    }
}
