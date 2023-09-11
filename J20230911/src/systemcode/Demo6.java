package systemcode;

/**
 * 单例模式 -- 懒汉模式[线程安全版本]
 */

class SingletonLazy {
    //保证new操作的原子性
    private volatile static SingletonLazy instance;

    private SingletonLazy() {
    }

    public static SingletonLazy getInstance() {
        //保证了高效率,若是多个线程均要进行加锁的话,效率很低
        //因为我们只需要实例化一次
        if (instance == null) {
            //加锁
            synchronized (SingletonLazy.class) {
                //判断是否已经有实例对象了
                if (instance == null) {
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }
}

public class Demo6 {
    public static void main(String[] args) {

    }
}
