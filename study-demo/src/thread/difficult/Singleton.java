package thread.difficult;

// 单例模式 -- 饿汉模式
public class Singleton {
    // 创建私有的类对象
    private static Singleton instance = new Singleton();

    // 构造器私有化
    private Singleton() {

    }

    // 提供公共的接口, 返回类的唯一实例
    public static Singleton getInstance() {
        return instance;
    }
}

class Demo1 {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        System.out.println(singleton1 == singleton2);
    }
}
