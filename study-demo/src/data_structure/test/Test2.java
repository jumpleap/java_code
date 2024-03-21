package data_structure.test;

// 验证private进行封装后, 是否能访问
public class Test2 {
    // 1.内部类的private 外部类是否能访问
    // 看成一个成员变量
    class Animal {
        private String name= "小猫";
    }

    public String get() {
        // new对象后可以访问
        Animal animal = new Animal();
        animal.name = "小狗";
        return animal.name;
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
        // 不能直接访问
        // cat.name
    }

    // 结论: 内部类中的私有成员可以直接访问, 而外部类中的私有成员不可直接访问(使用setter和getter方法)
    // 内部类可以看成当前类的一个成员变量, 外部类不行
}
