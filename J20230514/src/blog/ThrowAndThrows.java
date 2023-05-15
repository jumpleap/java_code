package blog;

import java.util.Scanner;

public class ThrowAndThrows {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int age = scanner.nextInt();

        try {
            checkAge(name, age);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    //throws位于方法头上，throws抛出的是异常类型,throws后面可以跟多个异常类型，使用逗号隔开
    private static void checkAge(String name, int age) throws ArithmeticException, NullPointerException {
        if (!(name.equals("jerry"))) {
            //throw位于方法体内，用于抛出异常对象，且只能抛出一个异常对象
            throw new ArithmeticException("姓名错误！");
        }
        if (!(age == 11)) {
            throw new NullPointerException("年龄错误！");
        }
        System.out.println("身份正确！");
    }
}
