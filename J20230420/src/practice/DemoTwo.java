package practice;

public class DemoTwo {
    public static void main(String[] args) {
        //类的使用和实例化
    }
}

@SuppressWarnings({"all"})
//类名必须使用大驼峰的命名规则
class WashMachine {
    public String brand;//品牌
    public String type;//类型
    public double weight;//重量
    public double length;//长
    public double width;//宽
    public double height;//高
    public String color;//颜色

    //在方法中的变量是局部变量
    public void rub() {
        int b = 10;//局部变量
    }

    //行为/成员方法
    public void washClothes() {//洗衣服
        System.out.println("洗衣服~");
    }

    public void dryClothes() {//甩干
        System.out.println("甩干衣服~");
    }

    public void setTime(){ // 定时
        System.out.println("定时功能");
    }
}


class Dog {
    public String name;
    public int age;
    public String color;

    public void eat() {
        System.out.println("吃饭！");
    }

    public void bark() {
        System.out.println("旺旺叫！");
    }

    //非public类的main方法
    public static void main(String[] args) {
        System.out.println("eat");
    }
}
