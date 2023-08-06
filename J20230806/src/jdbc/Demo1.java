package jdbc;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * jdbc低级版
 */
public class Demo1 {
    public static void main(String[] args) throws SQLException {
        //1.创建DataSource
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/java109?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("123456");

        //2.建立数据库服务器之间的连接，连接好了后，才能进行后续的请求-响应 交互
        Connection connection = dataSource.getConnection();

        //3.构建sql
        //String sql = "insert into student values (1,'张三')";
        //String sql = "insert into student values (2,'李四')";
        //String sql = "update student set name = '王五' where id = 1";
        String sql = "delete from student where id = 1";
        PreparedStatement statement = connection.prepareStatement(sql);

        System.out.println("sql = " + statement);

        //4.把sql发给服务器，返回值是一个整数，表示影响到的行数
        int line = statement.executeUpdate();
        System.out.println(line);

        //5.释放资源，关闭连接。释放顺序：后获取到的资源先释放
        statement.close();
        connection.close();
    }
}
