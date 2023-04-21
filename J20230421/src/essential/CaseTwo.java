package essential;

public class CaseTwo {
    public static void main(String[] args) {
        //使用javap -c 和 javap -v查看反汇编信息
        int x = 10;
        int y = 20;
        System.out.println(add(x, y));
    }

    public static int add(int x, int y) {
        return x + y;
    }
}
