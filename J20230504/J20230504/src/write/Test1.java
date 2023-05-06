package write;

@SuppressWarnings({"all"})

public class Test1 {
    public static void main(String[] args) {
        Integer num1 = new Integer(127);
        Integer num2 = new Integer(127);
        System.out.println(num1 == num2);//false

        Integer num3 = new Integer(128);
        Integer num4 = new Integer(128);
        System.out.println(num3 == num4);//fasle

        Integer num5 = 127;//底层使用Integer.valueOf()方法
        Integer num6 = 127;//-128~127
        System.out.println(num5 == num6);//true

        Integer num7 = 128;
        Integer num8 = 128;
        System.out.println(num7 == num8);//false

        Integer num9 = 127;//Integer.valueOf(127)
        Integer num10 = new Integer(127);
        System.out.println(num9 == num10);//false

        Integer num11 = 127;
        int num12 = 127;
        System.out.println(num11 == num12);//false

        Integer num13 = 128;
        int num14 = 128;
        System.out.println(num13 == num14);//true
    }
}


@SuppressWarnings({"all"})
class Demo {
    public static void main8(String[] args) {
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j);//false

        Integer m = 1; //底层使用了Integer.valueOf()
        Integer n = 1;//底层使用了Integer.valueOf();
        System.out.println(m == n);//true

        Integer x = 128;
        Integer y = 128;
        System.out.println(x == y);//false
    }

    public static void main7(String[] args) {
        System.out.println(Integer.MIN_VALUE);//-2147483648
        System.out.println(Integer.MAX_VALUE);//2147483647

        //判断是不是数字
        System.out.println(Character.isDigit('w'));//false
        //判断是不是字母
        System.out.println(Character.isLetter('q'));//true
        //判断是不是大写字母
        System.out.println(Character.isUpperCase('t'));//false
        //判断是不是小写字母
        System.out.println(Character.isLowerCase('v'));//true
        //判断是不是空格
        System.out.println(Character.isWhitespace(' '));//true
        //转成大写字母
        System.out.println(Character.toUpperCase('e'));//E
        //转成小写字母
        System.out.println(Character.toLowerCase('A'));//a
    }

    public static void main6(String[] args) {
        //1)包装类的parsexxx()方法
        String s = "123";
        Integer integer = Integer.parseInt(s);
        //分析：先转化为基本数据类型，再自动转向
        System.out.println(integer);//123

        //2)使用new Integer(String)的构造器
        String str = "1234";
        integer = new Integer(str);
        System.out.println(integer);//1234
    }

    public static void main5(String[] args) {
        //1) 使用连接运算符： +
        Integer integer = 10;//自动装箱
        String str = 10 + "";
        System.out.println(str);//10

        //2)使用包装类的toString()方法
        Integer integer1 = 20;
        String string = Integer.toString(integer1);
        System.out.println(string);//20

        //3)使用String类的valueOf()方法
        Integer integer2 = 30;
        String s = String.valueOf(integer2);
        System.out.println(s);//30
    }

    public static void main3(String[] args) {
        Object obj = true ? new Integer(10) : new Double(12.3);

        Object obj1;
        if (true) {
            obj1 = new Integer(10);
        } else {
            obj1 = new Double(12.3);
        }

        System.out.println(obj);//10.0
        System.out.println(obj1);//10
    }

    public static void main2(String[] args) {
        //以下代码是否正确？
        Double data = 100.12;
        Float num = 100.4f;
    }

    public static void main1(String[] args) {
        //自动拆箱
        Integer integer = 99;//自动装箱，底层调用Integer.valueOf方法
        int num = integer;//自动拆箱
        System.out.println(num);//99

        /*
        底层源码：
        public int intValue() {
            return value;
        }
         */
    }

    public static void main4(String[] args) {
        //自动装箱：int ——> Integer
        Integer integer = 10;//把int类型转化为了Integer类型
        System.out.println(integer);//10
        /*
        底层源码：
        public static Integer valueOf(int i) {
            //判断i是不是在-128到127范围内，是的话直接返回一个值
            if (i >= IntegerCache.low && i <= IntegerCache.high)
                return IntegerCache.cache[i + (-IntegerCache.low)];
            //不是的话需要new一个Integer的值
            return new Integer(i);
        }
         */
    }
}