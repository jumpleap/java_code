package essential;

import java.util.Arrays;
import java.util.Scanner;

public class CaseOne {
    public static void main(String[] args) {
        //局部变量的生命周期和作用域
        int a = 10;
        {
            int b = 20;
            //该局部变量的作用域和生命周期在定义自己的{}中
            System.out.println(a);//10
        }
        //System.out.println(b);//错误

        //怎么理解方法重载
        //方法重载：方法名相同，参数列表不同【个数不同，顺序不同，类型不同】，返回值无要求
        int num1 = 10;
        int num2 = 20;
        double data1 = 13.12;
        double data2 = 23.12;

        //求和的方法重载
        System.out.println(add(num1, num2));//30
        System.out.println(add(data1, data2));//36.24
        System.out.println(add(num1, num2, data1));//43.12

        //Scanner输入类中，next()和nextLine方法的区别
        //next()方法：在遇到空格、制表符、换行符后结束读取
        //nextLine()方法：遇到换行符后才会结束读取
        Scanner scanner = new Scanner(System.in);
        useNext(scanner);
        useNextLine(scanner);

        //null
        String str = null;
        //System.out.println(str.length());//出现空指针异常


    }

    public static void useNextLine(Scanner scanner) {
        //nextLine()方法：遇到换行符后结束读取
        String str = "";
        System.out.println("请输入一个字符串：");
        str = scanner.nextLine();
        System.out.println(str);

    }

    public static void useNext(Scanner scanner) {
        String str = "";
        //next()方法：在遇到空格、制表符、换行符后结束读取
        System.out.println("请输入一个字符串：");
        str = scanner.next();
        System.out.println(str);//hello
        scanner.nextLine();//消耗\n
    }

    /**
     * 求和的方法重载
     *
     * @param x
     * @param y
     * @return
     */
    public static int add(int x, int y) {
        return x + y;
    }

    public static double add(double x, double y) {
        return x + y;
    }

    public static double add(int x, int y, double z) {
        return x + y + z;
    }
    //main方法结束后，a销毁
}

class Demo1 {
    //成员变量：所占的空间是在堆上的
    public int score;
    public double data;

    public static void main(String[] args) {
        Demo1 demo = new Demo1();
        System.out.println(demo.score);//0
        System.out.println(demo.data);//0.0

        //一维数组
        int[] array = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(array));//[1, 2, 3, 4, 5, 6]

        //二维数组
        int[][] arr = new int[][]{{1, 2, 3}, {4, 5, 6}};
        System.out.println(Arrays.deepToString(arr));//[[1, 2, 3], [4, 5, 6]]
    }
}


class Demo {
    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 4, 5, 6};
        int[] copy = Arrays.copyOf(array,array.length);
        System.out.println(Arrays.toString(copy));//[2, 3, 4, 5, 6]

        /*
        //Arrays.copyOf(int[] original, int newLength)的底层源码
                        被拷贝的数组          要拷贝多少数据
        public static int[] copyOf(int[] original, int newLength) {
            int[] copy = new int[newLength];
            //底层使用System.arraycopy进行拷贝
            System.arraycopy(original, 0, copy, 0, Math.min(original.length, newLength));
            return copy;
        }
         */

        System.arraycopy(array,0,copy,0,5);
        /*
        public static native void arraycopy(Object src,  int  srcPos,
                                        Object dest, int destPos,
                                        int length);
         //1)Object src：源数组
         //2)int  srcPos：拷贝的起始地址
         //3)Object dest：目标空间
         //4)int destPos：从那个位置进行拷贝
         //int length：拷贝的长度
         */
        System.out.println(Arrays.toString(copy));//[2, 3, 4, 5, 6]

        int[] arr = new int[5];
        Arrays.fill(arr,1);
        System.out.println(Arrays.toString(arr));//[1, 1, 1, 1, 1]
        Arrays.fill(arr,1,3,-1);
    }
}

class ArrayOperate {
    public static void main(String[] args) {
        int[] arr = new int[5];
        Arrays.fill(arr,1);//arr数组中全部填充1
        System.out.println(Arrays.toString(arr));//[1, 1, 1, 1, 1]

        //在fromIndex - toIndex中填充-1 --->[1,3)
        Arrays.fill(arr,1,3,-1);
        System.out.println(Arrays.toString(arr));//[1, -1, -1, 1, 1]

        int[] arr1 = new int[]{1,2,3,4,5};
        int[] arr2 = new int[]{1,2,3,4,5};
        //equals(int[] arr1, int[] arr2):判断两个数组的值是否完全相等，返回类型：boolean
        System.out.println(Arrays.equals(arr1, arr2));
    }
}