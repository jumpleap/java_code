package blog;

public class CompareString {
    public static void main(String[] args) {
        String s1 = new String("abcde");
        String s2 = new String("abcde");

        //==：比较的是两个字符串的地址是否相同
        System.out.println(s1 == s2);//false

        //equals：比较的是两个字符串的内容是否相同【返回布尔值】
        System.out.println(s1.equals(s2));//true

        //compareTo：比较的是两个字符串的内容是否相等【返回整型】
        System.out.println(s1.compareTo(s2));//0
    }
}
