package write;

import java.util.Arrays;

@SuppressWarnings({"all"})
public class Test2 {
    public static void main(String[] args) {
        String s1 = "abcdef";
        String s2 = "java";
        String s3 = "abcdefjava";
        String s4 = (s1 + s2).intern();

        System.out.println(s3 == s4);//true
        System.out.println(s3.equals(s4));//true
    }
}


@SuppressWarnings({"all"})
class Case {
    String str = new String("jack");
    final char[] ch = {'j', 'a', 'v', 'a'};

    public void convert(String str, char[] ch) {
        str = "tom";
        ch[0] = 'k';
    }

    public static void main10(String[] args) {
        Case test = new Case();
        test.convert(test.str, test.ch);

        System.out.println(test.str);//jack
        System.out.println(test.ch);//kava
    }

    public static void main8(String[] args) {
        //以下代码创建了几个对象？
        String s1 = "hello";
        String s2 = "java";
        String s3 = s1 + s2;
    }

    public static void main7(String[] args) {
        //这句话创建了几个对象？
        String str = "hello" + "java";
    }

    public static void main6(String[] args) {
        String s1 = "hello";
        //Java中的字符串是不可变的，所有又创建了x一个新的对象，让s1指向它
        s1 = "hihi";
    }

    public static void main5(String[] args) {
        Person person1 = new Person();
        person1.name = "study";
        Person person2 = new Person();
        person2.name = "study";

        System.out.println(person1.name.equals(person2.name));//true
        System.out.println(person1.name == person2.name);//true
        System.out.println(person1.name == "study");//true
    }

    public static void main4(String[] args) {
        String s1 = "come on";
        String s2 = new String("come on");
        System.out.println(s1.equals(s2));//true
        System.out.println(s1 == s2);//false
        System.out.println(s1 == s2.intern());//true
        System.out.println(s2 == s2.intern());//false

        String str1 = "cheer up";
        String str2 = "cheer";
        String str3 = new String("cheer");
        String str4 = "cheer";
        System.out.println(str2 == str3);//false
        System.out.println(str2 == str4);//true
        System.out.println(str2.equals(str3));//true
        System.out.println(str1 == str2);//false
    }

    public static void main3(String[] args) {
        String s1 = "xyz";
        String s2 = "xyz";
        System.out.println(s1.equals(s2));//true
        System.out.println(s1 == s2);//true

        String str1 = new String("abc");
        String str2 = new String("abc");
        System.out.println(str1.equals(str2));//true
        System.out.println(str1 == str2);//false
    }

    public static void main2(String[] args) {
        String s = new String("white");
    }

    public static void main1(String[] args) {
        final char[] ch = new char[]{'a', 'b', 'c'};
        ch[0] = 'w';

        System.out.println(Arrays.toString(ch));//[w, b, c]
        //final修饰的引用不能在指向其他的对象
        //ch = new char[5];
    }
}

class Person {
    public String name;
}