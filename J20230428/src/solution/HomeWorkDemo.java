package solution;

public class HomeWorkDemo {
    /*
    在 java 中，一个类可同时定义为许多同名的方法，这些方法的形式参数个数，
    类型或顺序各不相同，传回的值可能各不相同，这种面向对象的特性称为（C）
        A.隐藏
        B.重写
        C.重载
        D.无此特性

    以下说法, 描述错误的是:B
        A.重载要求两个方法名字相同, 但是参数的类型和个数不同, 不要求返回值类型相同
        B.重写要求两个方法名字相同, 同时参数的类型和个数相同, 不要求返回值类型相同
        //返回值必须相同【重写的返回值必须是重写返回值的子类】
        C.重写的方法可以使用 @Override 注解来修饰
        D.父类的方法为 private 的时候, 子类方法不能进行重写.
     */

}

class B {
    public int Func() {
        System.out.print("B");
        return 0;
    }
}
class D extends B {
    @Override
    public int Func() {
        System.out.print("D");
        return 0;
    }
}
class Test {
    public static void main(String[] args) {
        B a = new B();
        B b = new D();
        a.Func();//B
        b.Func();//D
    }
}


class Person1{
    private String name = "Person";
    int age=0;
}

class Child extends Person1{
    public String grade;

    public static void main(String[] args){
        Person1 p = new Child();
        //System.out.println(p.name);//编译出错
    }
}