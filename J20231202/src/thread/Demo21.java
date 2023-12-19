package thread;

// 单例模式 -- 饿汉模式
public class Demo21 {
    public static void main(String[] args) {
        SingletonLazy s1 = SingletonLazy.getInstance();
        SingletonLazy s2 = SingletonLazy.getInstance();

        System.out.println(s1 == s2);
    }
}

class SingletonLazy {
    private static SingletonLazy instance = new SingletonLazy();

    // 结构器私有化, 防止外部类直接new
    private SingletonLazy() {

    }

    // 提供公共的接口, 返回当前new出来的类
    public static SingletonLazy getInstance() {
        return instance;
    }
}