package study.demo1;

public class Test {
    public static void main(String[] args) {
        Bird bird = new Bird("小麻雀", 1);
        Dog dog = new Dog("大黄", 3);
        test(bird);
        test1(bird);
        test2(bird);
        //test3(bird);//没有实现这个接口

        test(dog);
        test1(dog);
        test3(dog);

        Robot robot = new Robot();
        test1(robot);
    }

    //以下的所有方法均是使用了向上转型
    public static void test(Animal animal) {
        animal.eat();
    }

    public static void test1(IRunning running) {
        running.run();
    }

    public static void test2(IFlying flying) {
        flying.fly();
    }

    public static void test3(ISwimming swimming) {
        swimming.swim();
    }
}
