import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getParameter")
public class GetParameterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //此处约定, 请求中给定的query string是形如: username=zhangsan&password=123
        //上述querystring就会被tomcat自动解析成一个Map这样的结构
        //getParameter就是再查询Map<String, String>里的内容

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //拿到这两个内容, 就可以做处理了
        System.out.println("username: " + username);
        System.out.println("password: " + password);

        resp.getWriter().write("ok");
    }
}
