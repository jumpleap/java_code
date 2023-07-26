package string;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        char[] ch = new char[]{'a','b','c'};
        String s1 = new String(ch);
        /*
        public String(char value[]) {
            //底层进行了数组拷贝
            this.value = Arrays.copyOf(value, value.length);
        }
         */
        String s2 = "abc";
        System.out.println(s1 == s2);
        //s1.intern()：会把s1对象的引用放入到常量池中
        System.out.println(s1.intern() == s2);
    }

    public static void main1(String[] args) {
        //Map<String,Integer> map1 = new HashMap<>(1000);
        String s1 = "hello";
        String s2 = "hello";

        System.out.println(s1 == s2); //true

        String s3 = new String("hello");
        System.out.println(s1 == s3); //false
        String s4 = new String("hello");
        System.out.println(s3 == s4); //false
    }
}