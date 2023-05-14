package blog;

public class Test3 {
    public static void main(String[] args) {
        String s1 = new String("abc");
        String s2 = new String("abc");
        System.out.println(s1 == s2);

        System.out.println("====================");
        String str1 = "abcd";
        String str2 = "abcd";
        System.out.println(str1 == str2);
    }
}
