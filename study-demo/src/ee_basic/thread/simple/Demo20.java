package ee_basic.thread.simple;

// 解决死锁
/*
    形成死锁的四个必要条件:
        1) 互斥使用: 当一个线程持有一把锁之后, 另一个线程也想获取到该锁, 就要阻塞等待
        2) 不可抢占: 当锁已经被一个线程拿到后, 另一个线程只能等待拿到锁的线程主动释放, 不能强行抢锁
        3) 请求保持: 一个线程尝试获取多把锁; 即获取了锁1之后, 继续获取锁2
        4) 循环等待/环路等待: 等待的依赖关系形成环了
        注: 死锁的形成,必须满足以上这四个条件

    解决死锁,核心就是把四个必要条件破坏一个, 只要破坏一个, 死锁就形成不了;
        1) 互斥使用和不可抢占是synchronized的自带特性, 无法干预;
        2) 对于请求保持来说, 调正代码结构, 避免编写"锁嵌套"的逻辑
        3) 对于循环等待来说, 可以约定加锁的顺序, 就可以避免循环等待

    解决:
        把上述死锁代码进行修改成不是死锁的代码, 使用约定加锁的顺序来解决;
        约定: 在加多把锁的时候, 先加编号小的锁, 后加编号大的锁
 */
public class Demo20 {
    private final static Object locker1 = new Object();
    private final static Object locker2 = new Object();

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            synchronized (locker1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (locker2) {
                    System.out.println("thread加锁成功!");
                }
            }
        });

        Thread thread1 = new Thread(() -> {
            // locker这把锁被thread线程拿到了, 需要等待thread线程释放后才能拿到
            synchronized (locker1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (locker2) {
                    System.out.println("thread1加锁成功!");
                }
            }
        });

        thread.start();
        thread1.start();
    }
}
