package blog;

public class Test3 {
    public static void main(String[] args) {
        //抽象类不能实例化
        //Person person = new Person();
    }
}

//类也需要使用abstract修饰
abstract class Person {
    //一个方法是抽象方法，那这个类也必须是抽象类
    //抽象方法没有方法体
    public abstract void say();

    public abstract void run();

    //不能使用private、static、final关键字修饰抽象方法，因为它们与重写是冲突的
    //private abstract void hi();
    //public static abstract void hi();
    //public final abstract void hi();
}

//普通类继承抽象类需要实现抽象类中的所有的抽象方法
//抽象类的作用：抽象类是用来继承的，可以使用向上转型使用抽象类中的方法和属性
class Kid extends Person {
    @Override
    public void say() {

    }

    @Override
    public void run() {

    }
}

//抽象类中可以没有抽象方法
abstract class Teacher {
    //抽象类也是类，具有类的一切特点
    private String name;
    private int age;

    public Teacher(String name, int age) {
        this.name = name;
        this.age = age;
    }

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
}