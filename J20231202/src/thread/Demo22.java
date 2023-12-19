package thread;

// 单例模式 -- 饿汉模式
public class Demo22 {
    public static void main(String[] args) {
        SingletonHunger s = SingletonHunger.getInstance();
    }
}

class SingletonHunger {
    // volatile保证内存可见性
    private volatile static SingletonHunger instance;

    // 结构器私有化
    private SingletonHunger() {
    }

    // 提供公共的接口用于返回instance
    public static SingletonHunger getInstance() {
        // 第一个if是用于判断是否需要加锁
        if (instance == null) {
            // 这个加锁是防止多个线程进行创建SingletonHunger
            synchronized (SingletonHunger.class) {
                // 第二个if是用于判断是否需要创建
                if (instance == null) {
                    instance = new SingletonHunger();
                }
            }
        }
        return instance;
    }
}