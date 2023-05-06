package write;

import java.util.Arrays;
@SuppressWarnings({"all"})
public class StringMethod {
    public static void main(String[] args) {
        //equalsIgnoreCase:忽略大小写进行字符串的比较
        String s = "abcdef";
        String s1 = "ABcdef";
        System.out.println(s.equalsIgnoreCase(s1));//true

        //indexOf：获取字符在字符串中第一次出现的位置
        String s2 = "hjkdgzsgdsigdhjsgd";
        System.out.println(s2.indexOf('d'));//3

        //lastIndexOf：获取字符在字符串中最后一次出现的索引，找不到返回-1
        System.out.println(s2.lastIndexOf('j'));//15

        //substring：获取指定范围内的子串
        String s3 = "aajdhjshhdjdjh";
        System.out.println(s3.substring(5));//[5,end)
        System.out.println(s3.substring(1, 5));//[1,5)

        //trim：去掉前后空格
        String s4 = "  h dggdg  ";
        System.out.println(s4.trim());

        //获取某索引处的字符
        System.out.println(s4.charAt(5));//g

        //toUpperCase：把小写字母转大写字母
        System.out.println(s4.toUpperCase());
        System.out.println(s4);//需要接收返回值改变

        //toLowerCase：把大写字母转小写字母
        String s5 = "GFHGhdgagHUGuh";
        System.out.println(s5.toLowerCase());

        //concat：字符串连接
        String s6 = "jack".concat("ma").concat("hdhsh").concat("hhhh");
        System.out.println(s6);

        //replace: 替换字符串中的字符
        System.out.println(s6.replace('j', 'k'));//需要接收返回值

        //split：分割字符串
        String s7 = "hdjh,hshd,hdsh,uids";
        String[] strings = s7.split(",");
        System.out.println(Arrays.toString(strings));

        //compareTo：比较两个字符串的大小
        System.out.println(s7.compareTo(s6));

        //toCharArray：把字符串转化为字符数组【leetcode中常用】
        char[] chars = s7.toCharArray();
        System.out.println(chars);

        //format：格式化字符串
        String name = "jack";
        int age = 10;
        double sal = 123.12;
        String s8 = String.format("%s + 的年龄是%d，工资是：%.2f", name, age, sal);
        System.out.println(s8);
    }
}