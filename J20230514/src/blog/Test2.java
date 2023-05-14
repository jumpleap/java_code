package blog;

public class Test2 {
    public static void main(String[] args) {
        D d = new D();
    }
}

class B {
    public B() {
        func();
    }

    public void func() {
        System.out.println("B的func方法");
    }
}

class D extends B {
    private int num = 1;

    D() {
        super();
    }

    @Override
    public void func() {
        //分析为什么num是0？
        System.out.println(num);//0
        System.out.println("D的func方法");
    }
}
