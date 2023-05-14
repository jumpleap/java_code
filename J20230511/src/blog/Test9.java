package blog;

public class Test9 {
    public static void main(String[] args) {
        //null表示不指向任何对象
        String s1 = null;
        //""空串，字符串长度为0
        String s2 = "";

        System.out.println(s2.length());//0
        System.out.println(s1.length());//空指针异常
    }
}
