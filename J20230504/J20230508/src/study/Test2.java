package study;

public class Test2 {
    public static void main(String[] args) {
        Dog dog = new Dog("大黄", 18);
        dog.get();
        dog.run();
        dog.say();
        dog.swing();
        dog.getInfo();
    }
}

class Animal {
    private String name;
    public int age;
    public String jump = "动物跳";

    public Animal() {
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void say() {
        System.out.println("说话~");
    }

    public void run() {
        System.out.println("跑");
    }
}

//继承关系需要满足is a的特点
//继承对共性的抽取，完成对代码的复用【name,age,run(),say()】
class Dog extends Animal {
    private String jump = "小狗跳~";

    public Dog(String name, int age) {
        //super关键字指定父类的构造器
        //如果没有super(name, age);这里会默认有一个super();
        super(name, age);
    }

    @Override
    public void say() {
        System.out.println("小狗在叫~");
    }

    @Override
    public void run() {
        System.out.println("小狗在跑~");
    }

    //特有方法
    public void swing() {
        System.out.println("小狗在摇尾巴~");
    }

    public void getInfo() {
        //子类继承父类后，子类可以获得父类id全部属性【私有属性需要提供公共的方法获取】
        System.out.println(super.getName() + super.age);
    }

    //当父子类有重名的属性时，优先就近原则
    public void get() {
        System.out.println(jump);//小狗跳
    }
}

//Java是单继承机制，一个类只能继承一个类
//class Cat extends Animal ,Dog {}