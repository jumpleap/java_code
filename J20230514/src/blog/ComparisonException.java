package blog;

import java.io.FileNotFoundException;

public class ComparisonException {
    public static void main(String[] args) throws FileNotFoundException {
        printException();

        //进行运行时异常的捕获
        try {
            runtimeException();
        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println("算术异常~");
        }
    }

    /**
     * 运行时异常：如果不进行处理，则最后右JVM处理
     * 处理方式：try - catch -finally【捕获异常进行处理】
     * 处理方式：throws：抛给方法的调用者处理【如果方法的调用者也抛出……到最后由JVM处理】
     */
    private static void runtimeException() {
        System.out.println(10 / 0);
    }

    /**
     * 编译时异常必须在编译阶段就进行处理
     * 处理方式：try - catch -finally【捕获异常进行处理】
     * 处理方式：throws：抛给方法的调用者处理【如果方法的调用者也抛出……到最后由JVM处理】
     */
    private static void printException() throws FileNotFoundException {
        throw new FileNotFoundException("异常~");
    }
}