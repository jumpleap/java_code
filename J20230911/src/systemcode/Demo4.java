package systemcode;

/**
 * 单例模式 -- 饿汉模式[线程安全]
 */

class SingletonHunger {
    private static SingletonHunger instance = new SingletonHunger();

    //构造器私有化
    private SingletonHunger() {
    }

    //提供一个公共的接口
    public static SingletonHunger getInstance() {
        return instance;
    }
}

public class Demo4 {
    public static void main(String[] args) {
        SingletonHunger s1 = SingletonHunger.getInstance();
        SingletonHunger s2 = SingletonHunger.getInstance();

        System.out.println(s1.equals(s2));
    }
}