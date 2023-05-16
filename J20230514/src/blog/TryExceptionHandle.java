package blog;

import java.util.Scanner;

/**
 * try - catch - finally对异常的处理机制
 */
public class TryExceptionHandle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = {1, 2, 3, 4, 5};
        int num = scanner.nextInt();
        int data1 = 5;
        int data2 = 3;

        try {
            System.out.println(10 / num);
            System.out.println(arr[6]);
            //如果try中发生了异常，那么try后面的代码不执行；
            //若没有发生异常，执行完try块的代码，catch中的不执行，finally中的执行，然后执行后面的语句
            System.out.println(data1 * data2);
            System.out.println("try块中的代码执行结束~");
        } catch (ArithmeticException e) {
            //捕获到了相对应的异常才会进行操作，异常之后捕获一个；
            e.printStackTrace();//打错错误日志
            System.out.println("算术异常");
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("数组下标越界异常");
        } finally {
            //不管有没有发生异常，finally中的代码均要执行
            //经常在这个地方进行资源的关闭等操作
            scanner.close();//关闭键盘输入资源器
            System.out.println("finally块中的代码执行结束");
        }

        //捕获到了try块中的异常，才会执行到这个地方
        System.out.println("执行完了try - catch - finally中的代码~");
    }
}