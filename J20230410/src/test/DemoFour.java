package test;

public class DemoFour {
    public static void main(String[] args) {
        //理解强制类型转换并使用
        int a = 20;
        byte b = (byte)a;
        System.out.println(a);
        System.out.println(b);

        int i = 1500;
        byte j = (byte)i;
        System.out.println(j);//-36? ---补码的使用

        double score = 99.5;
        int it = (int)score;
        System.out.println(it);//99 ---> double---int -> 去掉了小数点后面的小数
    }
}
