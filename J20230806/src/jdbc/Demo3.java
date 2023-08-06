package jdbc;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * jdbc高级版
 */
public class Demo3 {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        //先创建DataSource
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/java109?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("123456");

        //建立连接
        Connection connection = dataSource.getConnection();

        //构建sql：进行循环添加数据
        boolean flag = true;

        while (flag) {
            System.out.println("请输入学号：");
            int id = scanner.nextInt();
            System.out.println("请输入姓名：");
            String name = scanner.next();

            String sql = "insert into student values (?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setString(2, name);
            System.out.println("sql = " + statement);

            //把sql发给服务器。返回的是一个整数，表示被影响到的行数
            int line = statement.executeUpdate();
            System.out.println(line);

            System.out.println("是否还要继续添加数据？true/false");
            String res = scanner.next();
            flag = res.equals("true");
            if (!flag) {
                //释放资源
                statement.close();
            }
        }

        //释放资源，后来的先释放
        connection.close();
    }
}