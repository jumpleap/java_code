package jdbc;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * jdbc对数据库的查询操作
 */
public class Demo4 {
    public static void main(String[] args) throws SQLException {
        //建立DataSource
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/java109?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("123456");

        //建立连接,并抛出异常
        Connection connection = dataSource.getConnection();

        //构造sql语句
        String sql = "select * from student where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, 1);

        //执行sql,resultSet得到查询到的结果集，即临时表
        ResultSet resultSet = statement.executeQuery();

        //对查询到的结果集进行遍历，把每一行的数据取出来遍历
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
