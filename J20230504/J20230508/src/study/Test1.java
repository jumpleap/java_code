package study;

public class Test1 {
    public static void main(String[] args) {
        Student student = new Student();
        student.up();
        student.hello();
        student.hi();
        student.say();
        student.run();
    }
}

class Person {
    public Person() {}

    public void say() {
        System.out.println("有人说：生命就是一场空~");
    }

    public Object hello() {
        return "hello";
    }

    public void hi() throws RuntimeException {
        System.out.println("有人跟我打招呼~");
    }

    void run() {
        System.out.println("有人在跑~");
    }

    //父类中使用private、static、final修饰的方法不能重写
    private void go() {
        System.out.println("gogogo");
    }

    public static void swim() {
        System.out.println("某人正在游泳~");
    }

    public final void up() {
        System.out.println("up");
    }
}

class Student extends Person {

    //方法重写发生在继承体系中,方法名和形参列表必须相同
    @Override
    public void say() {
        super.say();
    }

    //子类方法的返回类型要小于等于父类方法的返回类型[String < Object]
    @Override
    public String hello() {
        return (String) super.hello();
    }

    //子类方法抛出的异常小于等于父类抛出的异常
    /*
    @Override
    //错误，Exception > RuntimeException
    //void hi() throws Exception { super.hi();}
    */
    @Override
    public void hi() throws ArithmeticException {
        super.hi();
    }

    //子类方法的访问权限大于等于父类方法的访问权限
    @Override
    public void run() {
        super.run();
    }

    //构造器不能重写
    //public Person() {}
}
