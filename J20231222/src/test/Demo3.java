package test;

public class Demo3 {
    public static void main(String[] args) {
        int x = 10;
        int y = 20;
        int z = 15;
        boolean res = x++ > y++ && x++ > z++;
        System.out.println(x + " " + y + " " + z);//11 21 15
        boolean res1 = x++ > z++ & y++ > z++;
        System.out.println(x + " " + y + " " + z);//12 21 17
    }
}
