package demo;

@SuppressWarnings({"all"})
public class Test {
    public static void main(String[] args) {
        //静态的成员属性只会执行一次
        Dog dog = new Dog();
        //dog = new Dog();
        System.out.println("++++++++++++++++++++++++");
        Dog dog1 = new Dog();

        Derived derived = new Derived();
        derived.testFunc();
        derived.method();

        System.out.println("==================");
        final int[] array = {1,2,3,4,5};
        //array = new int[10];

        //final修饰基本数据类型的值的时候，这个值不能被改变；
        //final修饰引用类型的时候，引用类型的地址不能改变，即不能重新使用这个引用类型去new一个新对象
        final int a = 10;
        //a = 100;
    }
}

class Animal {
    public String name;
    public int age;
    public String color;

    {
        System.out.println("animal普通代码块~");
    }

    static {
        System.out.println("animal静态代码块~");
    }

    public Animal() {
        System.out.println("animal的无参构造器~");
    }

    public Animal(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }
}

class Dog extends  Animal {
    static {
        System.out.println("dog的静态代码块~");
    }

    {
        System.out.println("dog的普通代码块~");
    }

    public Dog() {
        System.out.println("dog的无参构造器~");
    }
}

class BaseOne {
    public int a = 1;
    public int b = 2;
    public int d = 99;

    public void func1() {
        System.out.println("父类func1()");
    }
}

class Derived extends BaseOne {
    public int c = 3;
    public int a = 4;

    public void func2() {
        System.out.println("func2");
    }

    public void func1(int a) {
        System.out.println("func1(int)");
    }

    public void func1() {
        System.out.println("子类func1()");
    }

    public void testFunc() {
        func2();//子类的
        func1(10);//子类的
        func1();//子类的func1
        super.func1();//父类的
    }

    public void method() {
        System.out.println(a);//4
        System.out.println(b);//2
        System.out.println(c);//3
        System.out.println(d);//99

        //调用父类的属性
        System.out.println(super.a);//1
        System.out.println(super.b);//2
        System.out.println(super.d);//99

        System.out.println(this.a);
        System.out.println(this.b);
        System.out.println(this.c);
        System.out.println(this.d);
    }
}