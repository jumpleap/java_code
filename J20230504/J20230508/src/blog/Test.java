package blog;

public class Test {
    public static void main(String[] args) {
        //向上转型的实质：父类的引用指向了子类的对象
        Animal animal = new Dog();

        //编译类型看左边，运行类型看右边
        //编译类型不可变，运行类型可变
        //编译类型：Animal； 运行类型：Dog
        Animal animal1 = new Dog();
        System.out.println(animal1.getClass().getSimpleName());//Dog
        animal1.say();//进行动态绑定，和运行类型进行绑定

        //编译类型：Animal； 运行类型：Cat
        animal1 = new Cat();
        System.out.println(animal1.getClass().getSimpleName());//Cat
        animal1.say();//进行动态绑定
    }
}

class Animal {
    public void say() {
    }
}

class Dog extends Animal {
    //方法重写：在子类中重写父类的方法
    @Override
    public void say() {
        System.out.println("狗在大叫~");
    }
}

class Cat extends Animal {
    @Override
    public void say() {
        System.out.println("小猫喵喵叫~");
    }
}