package blog;

public class Test1 {
    public static void main(String[] args) {
        final int[] array = {1, 2, 3, 4, 5};
        array[0] = 10;
        //分析为什么这个语句保错？
        //array = new int[10];
    }
}
