package blog;

public class Test1 {
    public static void main(String[] args) {
        Animal animal = new Dog();
        //得到运行类型的名字
        System.out.println(animal.getClass().getSimpleName());//Dog
        animal = new Cat();
        System.out.println(animal.getClass().getSimpleName());//Cat

        Animal animal1 = new Animal();
        System.out.println(animal1.getClass().getSimpleName());//Animal
        Animal animal2 = new Cat();
        System.out.println(animal2.getClass().getSimpleName());//Cat
    }
}


class Animal {

}

class Dog extends Animal {

}

class Cat extends Animal {

}