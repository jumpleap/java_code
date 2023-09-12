package thread;

/**
 * 单例模式 -- 线程安全版本
 */

/**
 * 饿汉模式
 */
class SingletonHunger {
    private SingletonHunger instance = new SingletonHunger();

    //构造器私有化
    private SingletonHunger() {
    }

    //提供公共的方法
    public SingletonHunger getInstance() {
        return instance;
    }
}

/**
 * 懒汉模式
 */
class SingletonLazy {
    //防止new关键字不上原子操作的,加上volatile
    private volatile static SingletonLazy instance;

    //构造器私有化
    private SingletonLazy() {
    }

    //提供公共的方法
    public static SingletonLazy getInstance() {
        //多加一个判断,为了保证高效率, 只需要第一次没有对象的时候加锁就行了, 后续的不需要加锁了
        if (instance == null) {
            //加锁
            synchronized (SingletonLazy.class) {
                if (instance == null) {
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }
}

public class Demo1 {
    public static void main(String[] args) {

    }
}
