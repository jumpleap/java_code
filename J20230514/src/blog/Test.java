package blog;

/**
 * 分析以下的代码。画出内存图
 */
public class Test {
    public static void main(String[] args) {
        String s = "hello";
        s += "world";
        System.out.println(s);

    }
}