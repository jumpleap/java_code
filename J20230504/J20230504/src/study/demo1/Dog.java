package study.demo1;

public class Dog extends Animal implements IRunning, ISwimming {
    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println(name + "正在吃骨头~");
    }

    @Override
    public void run() {
        System.out.println(name + "正在用它的狗腿子跑~");
    }

    @Override
    public void swim() {
        System.out.println(name + "正在用它的狗腿子游泳~");
    }
}
