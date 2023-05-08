package study;

public class FinalUse {
    public static void main(String[] args) {
        final int age = 10;
        //final修饰局部变量，局部变量的值不可改变
        //age = 20;

        //final修饰的类可以实例化
        //Stu stu = new Stu();
        System.out.println(Stu.BIRTHDAY);
    }
}

class Human {
    public final void say() {
        System.out.println("人会说话~");
    }
}

class Pupil extends Human {
    //final修饰的方法不能重写
    /*@Override
    public void say() {

    }*/
}

final class Stu {
    //final和static的搭配不会导致类加载
    public final static String BIRTHDAY = "12.12";

    static {
        //用于测试使用BIRTHDAY后类是否会加载，加载后输出
        System.out.println("静态代码块");
    }

    //final修饰的成员变量可以在三个地方赋值
    public final int AGE;

    //代码块
    {
        AGE = 10;
    }

    public final int NUM;

    //构造器
    public Stu() {
        NUM = 10;
    }

    //直接赋值
    public final int DATA = 10;
}

//final修饰的类不能被继承
//class Undergraduate extends Stu { }
