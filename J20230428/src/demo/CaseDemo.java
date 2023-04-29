package demo;

@SuppressWarnings({"all"})

public class CaseDemo {
    /**
     * 发生向上转型的三种方式
     * 直接赋值
     * 方法的传参
     * 返回值
     *
     * @param args
     */
    public static void main(String[] args) {
        //1.直接赋值：父类的引用指向子类的对象
        Animal animal = new Dog("小黄", 1);

        //2.方法的传参
        print(new Dog("大黄", 2));

        //3.返回值
        Animal animal1 = getDog();
    }

    private static Animal getDog() {
        return new Dog("大黄", 1);
    }

    private static void print(Animal animal) {
        //父类的引用接收子类的对象
        animal.eat();
        //狗特有的方法
        if (animal instanceof Dog) {
            ((Dog) animal).eat();
            ((Dog) animal).wangWang();
        }
    }

    public static void main1(String[] args) {
        //向上转型
        Animal animal = new Bird("小鸟", 10);
        animal.eat();
        //animal.fly();//需要向下转型
        if (animal instanceof Bird) {
            ((Bird) animal).fly();//向下转型
        }

        Animal animal1 = new Dog("小狗", 1);
        if (animal1 instanceof Dog) {
            //调用小狗特有的方法
            ((Dog) animal1).wangWang();
            ((Dog) animal1).eat();
        }
    }
}

class Animal {
    public String name;
    public int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //eat方法
    Animal eat() {
        System.out.println(name + "正在吃");
        return null;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}


class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }

    public void wangWang() {
        System.out.println(name + "正在旺旺叫~");
    }

    //重写父类的eat方法
    @Override
    Dog eat() {
        System.out.println(name + "正在吃狗粮~");
        return null;
    }
}


class Bird extends Animal {
    public Bird(String name, int age) {
        super(name, age);
    }

    public void fly() {
        System.out.println(name + "正在飞~");
    }
}