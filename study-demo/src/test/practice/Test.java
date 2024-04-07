package test.practice;


public class Test {
    public static void main(String[] args) {
        String a="My field1";
        String b="My field1";
        String c=new String("My field1");
        String d=new String("My field1");
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(c == d);
        System.out.println(a.equals(b));

        String str1="hello";
        String str2="he"+ new String("llo");
        System.out.println(str1.equals(str2));
    }
}

interface Com {
    int M = 200;

    int f();
}

class ImpCom implements Com {
    //【代码】

    @Override
    public int f() {
        return M;
    }
}