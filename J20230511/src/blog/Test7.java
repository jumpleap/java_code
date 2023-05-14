package blog;

public class Test7 {
    public static void main(String[] args) {
        A a = new A();
        //错误，私有变量在类外不能被访问
        //System.out.println(a.num);
    }
}

class A {
    private int num = 0;
}
