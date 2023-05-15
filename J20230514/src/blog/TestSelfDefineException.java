package blog;

import java.util.Scanner;

public class TestSelfDefineException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        //对异常进行处理
        try {
            checkName(name);
        } catch (SelfDefineException e) {
            e.printStackTrace();
            System.out.println("名字错误");
        }
    }

    //检查名字是否正确
    private static void checkName(String name) throws SelfDefineException {
        if (!name.equals("marry")) {
            //这个地方必须在方法处抛出该异常，因为他是一个编译时异常
            throw new SelfDefineException("名字错误");
        }
        System.out.println("名字正确");
    }
}


class SelfDefineException extends Exception {
    //常用构造器
    public SelfDefineException() {

    }

    public SelfDefineException(String message) {
        super(message);
    }
}