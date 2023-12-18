package thread;

// synchronized 的使用方法
public class Demo14 {
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();
        Thread t1 = new Thread(() -> {
            Count.increase2();
        });

        Thread t2 = new Thread(() -> {
            Count.increase2();
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        // System.out.println(count.getCount());
        System.out.println(Count.add);
    }
}


class Count {
    private int count;
    public static int add;

    // 针对普通方法进行自增
    public void increase() {
        synchronized (Count.class) {
            for (int i = 0; i < 50000; i++) {
                count++;
            }
        }
    }

    public synchronized void increase1() {
        for (int i = 0; i < 50000; i++) {
            count++;
        }
    }

    // 针对静态方法进行使用
    public static void increase2() {
        synchronized (Count.class) {
            for (int i = 0; i < 50000; i++) {
                add++;
            }
        }
    }

    public synchronized static void increase3() {
        for (int i = 0; i < 50000; i++) {
            add++;
        }
    }


    public int getCount() {
        return count;
    }
}