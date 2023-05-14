package blog;

import java.util.Arrays;
@SuppressWarnings({"all"})

public class Test6 {
    public static void main(String[] args) {
        //特殊字符的转义
        //|的转义
        String s1 = "123|133|123";
        String[] str = s1.split("\\|");
        System.out.println(Arrays.toString(str));//[123, 133, 123]

        //.号的转义
        String s2 = "185.123.456";
        String[] split = s2.split("\\.");
        System.out.println(Arrays.toString(split));//[185, 123, 456]

        // \的转义
        String s3 = "123\\345\\567";
        String[] split1 = s3.split("\\\\");
        System.out.println(Arrays.toString(split1));//[123, 345, 567]

        //以多个字符分割的连接符：|
        String s4 = "lihua&zhangsan=100,score=120,age=10";
        String[] split2 = s4.split("&|=|,");
        System.out.println(Arrays.toString(split2));
        //[lihua, zhangsan, 100, score, 120, age, 10]

        //多次分割
        String s5 = "name=lihua&age=10";
        String[] split3 = s5.split("&");
        for (int i = 0; i < split3.length; i++) {
            String[] split4 = split3[i].split("=");
            for (int j = 0; j < split4.length; j++) {
                System.out.println(split4[j]);
            }
        }
    }
}
