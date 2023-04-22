package practice;

public class DemoFour {
    public static void main(String[] args) {
        Student student = new Student();
        //执行顺序：普通代码块 > 构造器

        Student student1 = new Student();
        //1）静态代码块只会随着类的加载执行一次，那个静态代码块定义在先执行那个
        //2）普通代码new出来几个对象则需要执行几次，执行顺序那个定义在前先执行那个
        //3）执行顺序：静态代码块 > 普通代码块 > 构造器
        //System.out.println(student);//打印出地址:practice.Student@1b6d3586
        //可以看出这个地址：包名.类名+ @ + 哈希码的十六进制形式的表示
        System.out.println(student);

    }
}

class Student {
    //普遍成员变量/实例成员变量：定义再方法的外部，类的内部
    //对成员进行私有化：防止外部对象能直接修改成员变量
    private String name;
    private int age;

    //静态成员变量：静态属性是被该类的所有对象进行共享的
    public static String classRoom;

    //静态代码块
    static {
        System.out.println("静态代码块1~");
    }

    static {
        System.out.println("静态代码块2~");
    }

    //普通代码块
    {
        this.name = "jack";
        this.age = 19;
        System.out.println("普通代码块~");
    }

    //无参构造器
    public Student() {
        System.out.println("无参构造器~");
    }

    //构造器
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void call() {
        //静态方法内部不能直接调用非静态方法
        //say();
    }

    //普通方法
    public void say() {

    }

    //getter和setter方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //重写Object类的toString方法
    //查看Object类的toString()方法
    /*
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
     */
    public String toString() {
        return "姓名：" + this.name + "年龄：" + this.age;
    }
}
