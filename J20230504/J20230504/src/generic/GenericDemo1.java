package generic;


import java.util.ArrayList;

@SuppressWarnings({"all"})
/**
 * 引出泛型
 */
public class GenericDemo1 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();

        arrayList.add(new Dog("旺财", 10));
        arrayList.add(new Dog("发财", 1));
        arrayList.add(new Dog("小黄", 5));

        //加入这个以后会出现ClassCastException异常
        //arrayList.add(new Cat("招财猫", 8));

        //向下转型
        for (Object o : arrayList) {
            Dog dog = (Dog) o;
            System.out.println(dog.toString());
        }
    }
}

class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
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

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Cat {
    private String name;
    private int age;

    public Cat(String name, int age) {
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