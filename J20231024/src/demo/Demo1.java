package demo;

public class Demo1 {
    public static void main(String[] args) {
        Animal animal = new Cat();
        animal.seem();

        Cat cat = new Cat();

        System.out.println(cat instanceof Animal);
        System.out.println(cat.getClass());

        System.out.println(animal instanceof Cat);
        System.out.println(animal.getClass());
    }
}

class Animal {
    public void fun() {
        System.out.println("hello");
    }

    public void seem() {
        System.out.println("似乎");
    }
}

class Cat extends Animal {
    @Override
    public void seem() {
        System.out.println("小猫认为人类很可爱~");
    }
}