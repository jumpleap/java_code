package practice;

public class Demo {
    public static void main(String[] args) {

    }
}

abstract class Animal {
    public abstract void eating();
    private void say() {
        System.out.println("say");
    }
}

class Dog extends Animal{
    @Override
    public void eating() {

    }
}

class Cat extends Animal{
    @Override
    public void eating() {

    }
}

class Cow extends Animal{

    @Override
    public void eating() {
    }
}