package blog;

public class Test8 {
    public static void main(String[] args) {
        new B().hi();//匿名对象，只能使用一次
    }
}

class B {
    public void hi() {
        System.out.println("hi,bro");
    }
}