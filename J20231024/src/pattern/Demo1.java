package pattern;

/**
 * 饿汉式
 */
class SingletonHunger {

    //创建私有的类对象
    private static SingletonHunger instance = new SingletonHunger();

    //提供公共的接口
    public static SingletonHunger getInstance() {
        return instance;
    }

    //构造器私有化
    private SingletonHunger() {

    }
}

public class Demo1 {
    public static void main(String[] args) {
        SingletonHunger singletonHunger = SingletonHunger.getInstance();
    }
}