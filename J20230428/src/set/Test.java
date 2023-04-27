package set;

public class Test {
    public static void main(String[] args) {
        Integer num = 1223232323;
        int h;
        int hash = (h=num.hashCode()) ^ (h >>> 16);
        System.out.println(hash);
    }
}
