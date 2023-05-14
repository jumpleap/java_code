package practice;
@SuppressWarnings({"all"})

public class Test2 {
    public static void main(String[] args) {
        //装箱：把一个基本数据类型 转化为 包装类型的过程
        //自动装箱  &  显示装箱
        int a = 10;
        Integer b = a;//自动装箱
        System.out.println(b);

        Integer c = Integer.valueOf(a);//显示装箱
        System.out.println(c);
    }

    public static void main2(String[] args) {
        Integer a = new Integer(10);
        int b = a;//自动拆箱
        System.out.println(b);

        //显示拆箱 拆箱为自己指定的元素
        int c = a.intValue();
        System.out.println(c);

        double d = a.doubleValue();
        System.out.println(d);
    }

    public static void main1(String[] args) {
        Integer a = 100;
        Integer b = 100;
        System.out.println(a == b);//true

        Integer a2 = 128;
        Integer b2 = 128;
        System.out.println(a2 == b2);//false
    }
}
