package systemcode;

/**
 * 单例模式 -- 懒汉模式[线程不安全版本]
 */
class SingletonLazy1 {
    private static SingletonLazy1 instance;

    private SingletonLazy1() {}

    //涉及到了读和修改的操作,有修改的操作就会出现线程不安全的情况
    public static SingletonLazy1 getInstance() {
        if(instance == null) {
            instance = new SingletonLazy1();
        }
        return instance;
    }
}

public class Demo5 {
    public static void main(String[] args) {

    }
}