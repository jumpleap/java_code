package practice;

public class Login {
    private String userName = "admin";
    private String password = "123456";

    public static void main(String[] args) {
        Login login = new Login();

        try {
            login.loginInfo("admin", "123456");
        } catch (UserNameException e) {
            e.printStackTrace();
            System.out.println("UserNameException");
        } catch (PasswordException e) {
            e.printStackTrace();
            System.out.println("PasswordException");
        }
    }

    public void loginInfo(String username, String password) throws UserNameException, PasswordException {
        if (!(this.userName.equals(username))) {
            throw new UserNameException("用户名错误~");
        }
        if (!(this.password.equals(password))) {
            throw new PasswordException("密码错误~");
        }
        System.out.println("登录成功~");
    }
}


//自定义异常类
class PasswordException extends RuntimeException {
    public PasswordException() {
    }

    public PasswordException(String message) {
        super(message);
    }
}

class UserNameException extends RuntimeException {
    public UserNameException() {
    }

    public UserNameException(String message) {
        super(message);
    }
}