package pattern;

class SingletonLazy {
    //创建一个私有的类对象
    private volatile static SingletonLazy instance = null;

    //提供公共的接口
    public static SingletonLazy getInstance() {
        //若instance为空, 则初始化
        if (instance == null) {
            synchronized (SingletonLazy.class) {
                if (instance == null) {
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }

    //构造器私有化
    private SingletonLazy() {
    }

}

public class Demo2 {
    public static void main(String[] args) {
        SingletonLazy singletonLazy = SingletonLazy.getInstance();
    }
}
