package study.demo2;

public class Test implements C{
    public static void main(String[] args) {
        Test test = new Test();
        test.a();
        test.b();
        test.c();
    }

    @Override
    public void a() {
        System.out.println("a");
    }

    @Override
    public void b() {
        System.out.println("b");
    }

    @Override
    public void c() {
        System.out.println("c");
    }
}


interface A {
    void a();
}

interface B {
    void b();
}

//C这个接口继承接口A和接口B，即C拥有了这两个接口对应的方法
interface C extends A,B {
    void c();
}