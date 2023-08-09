package jdbc;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcCreate {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        //创建DataSource资源
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/java109?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("123456");

        //建立连接，并抛出异常
        Connection connection = dataSource.getConnection();

        //构建sql语句
        System.out.println("请输入id：");
        int id = scanner.nextInt();
        System.out.println("请输入姓名：");
        String name = scanner.next();
        String sql = "insert into student values(?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        //把插入的数据重新设置
        statement.setInt(1, id);
        statement.setString(2, name);

        //将sql语句发送给服务器,line是被影响的行
        int line = statement.executeUpdate();
        System.out.println(line);

        //关闭资源，后面的先关
        statement.close();
        connection.close();
    }
}
