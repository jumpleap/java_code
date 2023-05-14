package homework;

import java.util.Scanner;

/**
 * 实现一个简单的控制台版用户登陆程序, 程序启动提示用户输入用户名密码. 如果用户名密码出错,
 * 使用自定义异常的方式来处理
 */
public class Login {
    private String loginName = "admin";
    private String loginPasswd = "123456";

    public static void main(String[] args) {
        Login login = new Login();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("请输入用户名:");
            String name = scanner.nextLine();
            System.out.println("请输入密码:");
            String passwd = scanner.nextLine();

            try {
                if (!login.loginName.equals(name)) {
                    throw new LoginName("用户名错误~");
                } else if (!login.loginPasswd.equals(passwd)) {
                    throw new LoginPasswd("密码错误~");
                }
                System.out.println("登录成功~");
                break;
            } catch (LoginName e) {
                System.out.println(e.getMessage());
            } catch (LoginPasswd e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

class LoginName extends RuntimeException {
    public LoginName(String message) {
        super(message);
    }
}

class LoginPasswd extends RuntimeException {
    public LoginPasswd(String message) {
        super(message);
    }
}