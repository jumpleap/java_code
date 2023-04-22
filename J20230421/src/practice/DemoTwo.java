package practice;

public class DemoTwo {
    public static void main(String[] args) {
        //下面代码的运行结果是（）
        String s;
        //System.out.println("s="+s);//局部变量需要初始化


    }
}


class Test {
    private float f=1.0f;
    int m=12;
    static int n=1;

    static int cnt = 6;
    static{
        cnt += 9;
    }

    public String toString() {
        System.out.print("aaa");
        return "bbb";
    }

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test);
    }

    public static void main2(String[] args){
        System.out.println("cnt = " + cnt);
    }
    static{
        cnt /=3;
    };

    public static void main1(String args[]){
        Test t=new Test();
        System.out.println(t.f);
        System.out.println(Test.n);
    }
    public int aMethod(){
        /*static*/ int i = 0;//局部变量不能使用静态static修饰
        i++;
        return i;
    }

    public static void hello() {
        System.out.println("hello");
    }
}

class MyApplication {

    public static void main(String args[]){
        Test test = new Test();
        test.aMethod();
        int j = test.aMethod();
        System.out.println(j);
    }
    public static void main1(String[] args) {
        // TODO Auto-generated method stub
        Test test=null;
        test.hello();//无结果输出
    }
}


class Pvf{
    static boolean Paddy;
    public static void main(String args[]){
        System.out.println(Paddy);//自己类中的静态熟悉可以不需要类名
    }
}


class HasStatic {// 1
    private static int x = 100;// 2
    public static void main(String args[]) {// 3
        HasStatic hsl = new HasStatic();// 4
        hsl.x++;// 5
        HasStatic hs2 = new HasStatic();// 6
        hs2.x++;// 7
        hsl = new HasStatic();// 8
        hsl.x++;// 9
        HasStatic.x--;// 10
        System.out.println(" x=" + x);// 11
    }
}


class TestDemo{
    private int count;

    public static void main(String[] args) {
        TestDemo test=new TestDemo(88);
        System.out.println(test.count);//88
    }

    TestDemo(int a) {
        count=a;
    }
}