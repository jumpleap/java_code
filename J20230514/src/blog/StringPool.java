package blog;

public class StringPool {
    public static void main(String[] args) {
        String s1 = "jack";
        //解释：把"jack"放入常量池之前先检查常量池中是否有"jack"这个字符串常量；没有的话直接加入到常量池中
        //有的话，则把常量池中的字符串常量的地址返回
        String s2 = "jack";

        //比较的话，可以看出两者的地址相同
        System.out.println(s1 == s2);//true
    }
}
