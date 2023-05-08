package study;

public class Test {
    public static void main(String[] args) {
        Teacher jack = new Teacher("jack", 12);
        jack.get();
    }
}

class People {
    public String name;
    public int age;
    public String sports;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void say() {
        System.out.println("某人说");
    }
}

class Teacher extends People {

    public Teacher(String name, int age) {
        //super访问父类的构造器为父类进行初始化
        super(name, age);
    }

    //使用super调用父类的方法和属性
    public void get() {
        //super在子类中使用
        super.sports = "badminton";
        super.say();
    }
}
