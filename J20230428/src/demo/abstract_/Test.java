package demo.abstract_;

public class Test {
    public static void drawMap(Shape shape) {
        shape.draw();
    }
    public static void main(String[] args) {
        //Shape shape = new Shape();
        Shape shape = new Rect();//向上转型
        drawMap(new Rect());
        drawMap(new Flower());
        //new Rect() -> 匿名对象 没有名字的对象
        //匿名对象的缺点是什么 ？  每次使用 都得重新实例化
        Rect rect = new Rect();
        rect.draw();
        rect.draw();

        new Rect().draw();
        new Rect().draw();

    }
}

abstract class Shape {
    /*public int a = 10;*/
    /* public Shape() {
        //用来让子类调用 帮助这个抽象类 初始化 自己的成员
    }*/

    public abstract void draw();

    /*public void test() {

    }*/
}

abstract class A extends Shape {
    public abstract void test();
}

//出来混 迟早要还的
class B extends A {
    @Override
    public void draw() {

    }

    @Override
    public void test() {

    }
}

class Rect extends Shape {
    @Override
    public void draw() {
        System.out.println("矩形");
    }
}

class Flower extends Shape {
    @Override
    public void draw() {
        System.out.println("❀");
    }
}
