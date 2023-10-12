package leetcode;

public class Demo1 {
    public static void main(String[] args) {
        //在jdk1.5之后，下列 java 程序输出结果为______。
        int i = 0;
        Integer j = new Integer(0);
        System.out.println(i == j); //Integer和整型进行比较, 是进行值比较
        System.out.println(j.equals(i)); //true
    }

    /*
    在 java 中，一个类可同时定义为许多同名的方法，这些方法的形式参数个数，类型或顺序各不相同，传回的
    值可能各不相同，这种面向对象的特性称为（方法重写）
    方法重写: 方法名相同, 参数列表不同: 类型, 个数, 顺序. 返回类型和修饰符无关联

    注: 使用new关键字的地址均是在堆上开辟内存空间的

    5. JAVA语言的下面几种数组复制方法中，哪个效率最高？
    A for循环逐一复制  -> 最慢, 需要一个一个的复制
    B System.arraycopy -> 浅拷贝, 速度最快
    C Arrays.copyOf 底层使用的就是System.arraycopy
    D 使用clone方法 -> 数组类型进行浅拷贝, 引用类型进行深拷贝
    效率排序: for循环 < Arrays.copyOf < clone < System.arraycopy
     */

    public static void main1(String[] args) {
        String x = "fmn";
        //toUpperCase的返回值是String, 但是x使用之后并没有使用一个变量接收,所有x字符串中的内容不变
        x.toUpperCase();
        String y = x.replace('f', 'F');
        y = y + "wxy";
        System.out.println(y);
    }
}


class Person {
    String name = "No name";

    public Person(String nm) {
        name = nm;
    }
}

class Employee extends Person {
    String empID = "0000";

    //没有调用父类的构造, 编译出错
    public Employee(String id) {
        super("jack");
        empID = id;
    }
}

class Test {
    public static void main(String args[]) {
        Employee e = new Employee("123");
        System.out.println(e.empID);
    }
}

class TestClass {
    private static void testMethod() {
        System.out.println("testMethod");
    }

    public static void main(String[] args) {
        //静态方法会被所有的类调用
        ((TestClass) null).testMethod();
    }
}

class Example {
    String str = new String("hello");
    char[] ch = {'a', 'b'};

    public static void main(String args[]) {
        Example ex = new Example();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str + " and ");
        System.out.print(ex.ch);
    }

    //str是一份对hello的拷贝, 在堆中这个str又指向test ok, 不影响原来的str指向hello
    public void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'c';
    }
}