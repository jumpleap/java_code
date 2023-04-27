package solution;

//不同包的情况下：导入Case对应的包

import casedemo.Case;

@SuppressWarnings({"all"})

public class SolutionProblem {
    //基本数据类型
    public char ch;
    public byte num1;
    public short num2;
    public int num3;
    public long num4;
    public float data1;
    public double data2;
    public boolean flg;

    //引用类型
    String str;

    public static void main(String[] args) {
        SolutionProblem solutionProblem = new SolutionProblem();
        System.out.println(solutionProblem.ch);//'\u0000'
        System.out.println(solutionProblem.num1);//0
        System.out.println(solutionProblem.num2);//0
        System.out.println(solutionProblem.num3);//0
        System.out.println(solutionProblem.num4);//0
        System.out.println(solutionProblem.data1);//0.0
        System.out.println(solutionProblem.data2);//0.0
        System.out.println(solutionProblem.flg);//false
        System.out.println(solutionProblem.str);//null
    }
}

class SolutionProblem4 extends Case {
    public void useAttribute() {
        //调用不同包中的属性和方法
//        System.out.println(result);//gitee
//        say();//say()方法
//        System.out.println(super.result);
//        super.say();
    }

    public static void main(String[] args) {
        SolutionProblem4 solutionProblem = new SolutionProblem4();
        solutionProblem.useAttribute();
    }
}

/**
 * 类的加载
 */
class Person {
    public Person() {
        System.out.println("person的无参构造器~");
    }
}

class SolutionProblem3 extends Person {
    public static int num = 10;

    {
        System.out.println("SolutionProblem的实例代码块~");
    }

    static {
        System.out.println("SolutionProblem的静态代码块~");
    }

    public SolutionProblem3() {
        System.out.println("SolutionProblem的无参构造器~");
    }

    public static void main(String[] args) {
        //创建对象实例的时候进行类加载
        //SolutionProblem solutionProblem = new SolutionProblem();

        //使用静态成员的时候进行类加载
        //System.out.println(SolutionProblem.num);
        //运行结果：SolutionProblem的静态代码块~ 10

        //创建子类对象时，父类对象先进行类加载
        SolutionProblem3 solutionProblem = new SolutionProblem3();
        //运行结果：
        //SolutionProblem的静态代码块~ person的无参构造器~
        //SolutionProblem的实例代码块~ SolutionProblem的无参构造器~
    }
}


/**
 * 为什么this和super不能使用在静态成员中？
 */
class Father {
    public void say() {
        System.out.println("say~");
    }
}

class SolutionProblem2 extends Father {
    public static int num;

    public static void main(String[] args) {
        SolutionProblem2 solutionProblem = new SolutionProblem2();
        int num = 10;
        solutionProblem.print(num);
        System.out.println(num);

    }

    /**
     * 静态成员中不能使用this和super关键字
     *
     * @param num
     */
    private static void print(int num) {
        //super.say();
        //this.num = num;
    }
}

/**
 * 局部变量和成员变量的区别
 */
class SolutionProblem1 {
    //成员变量定义在类中，方法外
    //num的作用域是整个SolutionProblem类
    //num可以使用访问权限修饰符：public、protected、private
    public int num;//在堆中开辟空间
    public int data;

    public static void main(String[] args) {
        //solutionProblem对象存在则num变量存在，solutionProblem变量销毁则num变量销毁
        SolutionProblem1 solutionProblem = new SolutionProblem1();
        //data的作用域在main{}内，出main后不能使用
        //data不能使用访问权限修饰符，只可以使用final修饰
        int data = 10;//在栈中开辟空间
        System.out.println(data);//10，就近访问原则
        print(data);
        //成员变量有默认值，可以直接使用
        System.out.println(solutionProblem.num);//0
    }

    /**
     * 局部变量定义方法内或方法声明上
     *
     * @param data
     */
    private static void print(int data) {
        //调用print类goal变量存在，调用结束后goal变量被销毁
        int goal = 10;//局部变量
        //局部变量在使用之前需要赋值或初始化
        System.out.println(goal);//10
    }
}
