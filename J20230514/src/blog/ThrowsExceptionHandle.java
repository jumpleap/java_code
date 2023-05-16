package blog;

import java.io.FileNotFoundException;

/**
 * throws对异常的处理机制
 */
public class ThrowsExceptionHandle {
    public static void main(String[] args) throws FileNotFoundException {
        //编译时异常的处理：抛出给JVM处理
        throwsCaseOne();

        //运行时异常：这里使用try - catch处理
        try {
            throwsCaseTwo();
        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println("算术异常");
        }
    }

    /**
     * throws对编译时异常的处理：直接抛出，一直抛出到给JVM处理
     */
    private static void throwsCaseOne() throws FileNotFoundException {
        throw new FileNotFoundException("IO流异常");
    }

    /**
     * 运行时异常的处理：使用try - catch - finally处理 或抛出给方法的调用者处理
     * throws可以抛出多个异常，如果是父子类关系的异常直接抛出父类即可
     * 注：尽量在方法头抛出异常，便于后期的维护
     */
    private static void throwsCaseTwo() throws ArithmeticException, ArrayIndexOutOfBoundsException {
        int a = 0;
        int[] arr = {1, 23, 4};
        System.out.println(10 / a);
        System.out.println(arr[4]);
    }
}