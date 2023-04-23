package casedemo;

public class Case {
    public static void main(String[] args) {
        //接口不能实例化
    }
}

interface Usb {
    //抽象方法
    Object use()throws RuntimeException;//抽象方法，有abstract和public修饰

    //从jdk1.8开始，接口中可以有默认方法
    default void can(){
        System.out.println("hello,bit");
    }

    //静态方法
    public static void say() {
        System.out.println("静态方法~");
    }
}

class Computer implements  Usb {
    //String < Object; ArithmeticException < Exception
    public String use() throws ArithmeticException {
        return "2";
    }
}