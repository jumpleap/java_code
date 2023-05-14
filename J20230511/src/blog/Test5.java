package blog;

public class Test5 {
    public static void main(String[] args) {
        //包装类转String类【Integer -> String】
        //包装类的toString方法
        Integer integer = 10;//自动装箱
        String s1 = integer.toString();
        System.out.println(s1);//10

        //String的valueOf方法
        String s2 = String.valueOf(integer);
        System.out.println(s2);//10

        //使用连接符 “+”
        String s3 = "";
        s3 = s3 + integer;
        System.out.println(s3);//10

        System.out.println("=======================");
        //String类转包装类【String -> Integer】
        //包装类的parseXxx方法
        String str1 = "1234";
        String str2 = "121.12";
        Integer num1 = Integer.parseInt(str1);
        Double num2 = Double.parseDouble(str2);
        System.out.println(str1 + " " + str2);//1234  121.12

        //使用包装类的构造器
        String str3 = "123";
        Integer data = new Integer(str3);
        System.out.println(data);//123
    }
}
