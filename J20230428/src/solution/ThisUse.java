package solution;

/**
 * this作用详解
 */
public class ThisUse {
    public static void main(String[] args) {
        Animal animal = new Animal();
        //animal调用Animal类中的方法，则当前的this代表Animal
        animal.run();
    }
}

class Animal {
    public String name;
    public int age;

    public Animal() {
        //调用其他的构造器
        //System.out.println("Animal的无参构造器~");
        this("大黄", 12);//必须放在构造器中的第一条语句
    }

    public Animal(String name, int age) {
        //this();//错误，两个构造器之间不能形成环，即无限构造
        this.name = name;
        this.age = age;
    }

    public void run() {
        //this访问对象中的变量
        System.out.println(this.name + "在跑~");
        //this访问对象中的方法
        //谁调用这个run方法，this就代表谁【animal】
        this.say();

    }

    public void say() {
        System.out.println(this.name + "在叫~");
    }
}