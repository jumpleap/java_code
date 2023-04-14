package basicknow;

public class Test414 {
    public static void main(String[] args) {
        System.out.println(5 / 2);//2
        System.out.println((float) 5 / 2);//2.5
        System.out.println((float) (5 / 2));//2.0
        System.out.println(5 / (float) 2);//2.5


        System.out.println(10 % 3);//1
        System.out.println(10 % -3);//1
        System.out.println(-10 % -3);//-1
        System.out.println(-10 % 3);//-1
        System.out.println(11.5 % 2);//1.5

        int a = 1;
        int b = 2;
        System.out.println(a == 1 && b == 2); //true
        System.out.println(a == 1 && b > 100); //false
        System.out.println(a > 100 && b == 2); //false
        System.out.println(a > 100 && b > 100); //false


//        int a = 10;
//        int b = 20;
//        // 注意：在Java中 = 表示赋值，要与数学中的含义区分
//        // 在Java中 == 表示相等
//        System.out.println(a == b); // false
//        System.out.println(a != b); // true
//        System.out.println(a < b); // true
//        System.out.println(a > b); // false
//        System.out.println(a <= b); // true
//        System.out.println(a >= b); // false
//        //System.out.println(3 < a < 5);
    }
}
