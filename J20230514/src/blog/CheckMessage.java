package blog;

import java.util.Scanner;

public class CheckMessage {
    private String name = "小强";
    private char gender = '男';

    public static void main(String[] args) {
        CheckMessage checkMessage = new CheckMessage();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入姓名：");
        String name = scanner.nextLine();
        System.out.println("请输入性别：");
        //获取字符串的第一个字符
        char gender = scanner.nextLine().charAt(0);

        try {
            checkMessage.checkInfo(name, gender);
        } catch (NameException e) {
            e.printStackTrace();
            System.out.println("名字错误");
        } catch (AgeException e) {
            e.printStackTrace();
            System.out.println("性别错误");
        }
    }

    //检查信息是否正确
    private void checkInfo(String name, char gender) throws NameException, AgeException {
        if (!(this.name.equals(name))) {
            throw new NameException("姓名错误");
        }
        if (!(this.gender == gender)) {
            throw new AgeException("性别错误~");
        }
        System.out.println("身份信息正确");
    }
}


//姓名异常类
class NameException extends RuntimeException {
    public NameException() {
    }

    public NameException(String message) {
        super(message);
    }
}

//年龄异常类
class AgeException extends RuntimeException {
    public AgeException() {
    }

    public AgeException(String message) {
        super(message);
    }
}