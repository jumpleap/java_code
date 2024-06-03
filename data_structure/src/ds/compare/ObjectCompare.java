package ds.compare;

// 对象的比较
public class ObjectCompare {
    // 包装类和基本类的比较
    public static void main(String[] args) {

    }

    // 基本类型的比较
    public static void main1(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println(a > b);
        System.out.println(a < b);
        System.out.println(a == b);

        char c1 = 'A';
        char c2 = 'B';
        System.out.println(c1 > c2);
        System.out.println(c1 < c2);
        System.out.println(c1 == c2);

        boolean b1 = true;
        boolean b2 = false;
        System.out.println(b1 == b2);
        System.out.println(b1 != b2);
    }
}
