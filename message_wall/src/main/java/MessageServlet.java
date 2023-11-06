import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/message")
public class MessageServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();

    //引用数据库, 此时的顺序表就不需要使用了
    //private List<Message> messageList = new ArrayList<>();

    private DataSource dataSource = new MysqlDataSource();

    @Override
    public void init() throws ServletException {
        //1.创建数据源
        ((MysqlDataSource) dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/message_wall?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("123456");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //读取前端发来的数据, 把这个数据保存到服务器这边
        Message message = objectMapper.readValue(req.getInputStream(), Message.class);
        System.out.println("请求中收到的message: " + message);

        //把这个数据添加到顺序表中
        //messageList.add(message);

        //最简单的方法, 直接在内存中保存, 可以使用一个集合类, 把所有收到的message都存到内存中
        //很明显, 保存到内存, 并非是一个非常合理的办法, 后续一旦启动服务器, 数据丢失了
        //相比之下, 把这个数据持久化存储到数据库中, 是更科学的
        //插入数据库
        try {
            save(message);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //返回一个响应
        resp.setStatus(200);
        resp.getWriter().write("ok");
        //resp.setContentType("application/json");
        //resp.getWriter().write("{ ok: true }");
    }

    private void save(Message message) throws SQLException {
        //通过这个方法把message存储到数据库中

        //1.建立连接
        Connection connection = dataSource.getConnection();

        //2.构造sql
        String sql = "insert into message values(?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, message.from);
        statement.setString(2, message.to);
        statement.setString(3, message.message);

        //3.执行sql
        statement.executeUpdate();

        //4.回收资源
        statement.close();
        connection.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过这个方法来处理当前获取消息列表的get请求, 不需要解析参数, 直接返回数据即可
        resp.setStatus(200);
        resp.setContentType("application/json; charset=utf8");

        //从数据库查询
        List<Message> messageList = null;

        try {
            messageList = load();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //获取当前List中的所有数据, 把这些数据转化为json字符串
        String respJson = objectMapper.writeValueAsString(messageList);

        //返回响应
        resp.getWriter().write(respJson);
    }

    private List<Message> load() throws SQLException {
        //通过这个方法从数据库中查询数据

        //1.建立连接
        Connection connection = dataSource.getConnection();

        //2.构造sql
        String sql = "select * from message";
        PreparedStatement statement = connection.prepareStatement(sql);

        //3.执行sql
        ResultSet resultSet = statement.executeQuery();

        //4.遍历结果集合
        List<Message> messageList = new ArrayList<>();
        while(resultSet.next()) {
            Message message = new Message();
            message.from = resultSet.getString("from");
            message.to = resultSet.getString("to");
            message.message = resultSet.getString("message");
            messageList.add(message);
        }

        //5.回收资源
        resultSet.close();
        statement.close();
        connection.close();

        //6.返回messageList
        return messageList;
    }
}