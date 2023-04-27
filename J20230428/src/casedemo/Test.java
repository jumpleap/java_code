package casedemo;

@SuppressWarnings({"all"})

/**
 * 继承中类的调用顺序
 */
public class Test {
    public static void main(String[] args) {
        Son son = new Son();
        //输出：1）老爹叫老妈~~ 2）60 3）10 4）Son的静态代码块
        //5）Father的实例代码块~ 6）老爹叫老妈~~ 7）Father的构造器~~
        //8）Son的实例代码块~~ 9）Son的构造器~~
    }
}

//父类
class Father {
    public String name;
    public static int age = 60;

    static {
        say();
        System.out.println(age);
    }

    {
        System.out.println("Father的实例代码块~");
    }

    public Father() {
        say();
        System.out.println("Father的构造器~~");
    }

    public static void say() {
        System.out.println("老爹叫老妈~~");
    }
}

//子类
class Son extends Father {
    public static int num = 10;

    static {
        System.out.println(num);
        System.out.println("Son的静态代码块~");
    }

    {
        System.out.println("Son的实例代码块~~");
    }

    public Son() {
        System.out.println("Song的构造器~");
    }
}


/**
 * 静态成员和实例成员的区别
 */
class Test1 {
    public static void main(String[] args) {
        //实例成员只有在创建对象的时候才会进行初始化
        Cat kily = new Cat("kily");//创建对象的时候，在堆中给kily分配空间

        System.out.println(kily.name);//使用对象名访问
        //静态成员随着类的加载而加载
        System.out.println(Cat.age);//使用类名访问

        //静态成员被当前类的所有对象共享
        //在创建对象的时候才进行初始化
        Cat carry = new Cat("carry");
        System.out.println(carry.age);//也能访问age

    }
}

class Cat {
    public String name;//成员变量
    //静态成员在类加载的时候开辟空间并进行初始化，存储在方法区中
    public static int age = 10;//静态变量

    public Cat(String name) {
        this.name = name;
    }

    //静态方法
    public static void run() {
        //静态方法只能访问静态成员
        System.out.println(age);
        //say();
        System.out.println("小猫快快跑~");
    }

    //成员方法
    public void say() {
        //成员方法既能访问静态成员，也能访问实例成员
        run();//静态方法
        System.out.println(age);//静态变量
        System.out.println(name + "喵喵叫~");
    }
}
