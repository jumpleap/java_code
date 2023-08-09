package jdbc;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcSearch {
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
        String sql = "select * from student";
        PreparedStatement statement = connection.prepareStatement(sql);
        //获取查询的结果集
        ResultSet resultSet = statement.executeQuery();

        //遍历查询的结果集
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println("id = " + id + ", name = " + name);
        }

        //关闭资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
