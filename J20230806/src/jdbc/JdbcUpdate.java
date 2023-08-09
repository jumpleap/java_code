package jdbc;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcUpdate {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        //创建DataSource资源
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/java109?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("123456");

        //建立连接
        Connection connection = dataSource.getConnection();

        //构建sql语句
        System.out.println("请输入新的姓名：");
        String name = scanner.next();
        String sql = "update student set name = ? where name = 'lisi'";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);

        //把sql语句发送给mysql服务器
        int line = statement.executeUpdate();
        System.out.println(line);

        //释放资源
        statement.close();
        connection.close();
    }
}