package thread.difficult;

// 单例模式 -- 懒汉模式
public class SingletonLazy {
    // 创建类的唯一实例
    private static SingletonLazy instance;

    // 构造器私有化
    private SingletonLazy() {

    }

    // 返回唯一实例的接口
    public static SingletonLazy getInstance() {
        // 若对象已存在, 线程安全, 无需加锁
        if (instance == null) {
            // 进来了, 若对象不存在, 需要进行加锁, 保证new对象的原子性
            // 若对象存在, 再进行一次判断, 防止出现多次new对象的情况
            synchronized (SingletonLazy.class) {
                // 再进行一次判断, 防止出现穿插的情况
                if (instance == null) {
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }

}

class Demo2 {
    public static void main(String[] args) {
        SingletonLazy singletonLazy1 = SingletonLazy.getInstance();
        SingletonLazy singletonLazy2 = SingletonLazy.getInstance();
        System.out.println(singletonLazy1 == singletonLazy2);
    }
}
