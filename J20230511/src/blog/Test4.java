package blog;

public class Test4 {
    public static void main(String[] args) {
        //接口不能实例化
        //Usb usb = new Usb();

        //接口可以发生向上转型和动态绑定
        //向上转型
        Usb usb = new Computer();
        //动态绑定
        usb.connection();
        usb.connect();
    }
}

//接口使用interface关键字修饰
interface Usb {
    //接口中的属性均是public static final类型的
    int USE_AGE = 10;

    //接口中的方法均是public abstract修饰的【除了default、static方法外】
    void connect();

    void connection();

    //接口中不能有代码块和构造器
    //public Usb() {}
    /*static {

    }*/

    //默认方法
    default void con() {

    }

    //静态方法
    static void hi() {

    }
}

//普通类实现接口后，需要把接口中的方法均重写
class Computer implements Usb {
    @Override
    public void connect() {

    }

    @Override
    public void connection() {

    }
}

//如果实现接口后，不想重写接口中的方法，那么将这个类声明为抽象类
abstract class Laptop implements Usb {

}