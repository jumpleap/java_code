import java.util.Scanner;

@SuppressWarnings({"all"})
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //boolean flag = login(scanner);
        new ContactManager().functionMenu();
//        if (!flag) {
//            System.out.println("你操作的太频繁了，一会再试试吧~");
//        } else {
//            new ContactManager().functionMenu();
//        }
    }

    public static boolean login(Scanner scanner) {
        //设置用户名和密码
        String userName = "admin";
        String userPwd = "123456";

        String loginName = "";
        String loginPwd = "";

        for (int i = 1; i <= 3; i++) {
            System.out.println("请输入你的用户名：");
            loginName = scanner.nextLine();
            System.out.println("请输入你的密码：");
            loginPwd = scanner.nextLine();

            //登录判断
            if (loginName.equals(userName) && loginPwd.equals(userPwd)) {
                return true;
            } else {
                if(i != 3)
                    System.out.println("密码或用户名错误，你还有" + (3 - i) + "次机会");
                else
                    break;
            }
        }
        return false;
    }
}
