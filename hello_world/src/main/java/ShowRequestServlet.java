import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/show")
public class ShowRequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //调用HttpServletRequest中的api, 把得到的结果拼接到字符串中
        StringBuilder sb = new StringBuilder();
        sb.append(req.getProtocol());//得到协议名和版本号
        sb.append("<br>");
        sb.append(req.getMethod());//获取方法
        sb.append("<br>");
        sb.append(req.getRequestURI());//完整路径到@WebServlet("/show")中的show这个路径
        sb.append("<br>");
        sb.append(req.getContextPath());//得到顶级路径
        sb.append("<br>");
        sb.append(req.getQueryString());//获取查询字符串
        sb.append("<br>");

        //获取所有的header部分
        Enumeration<String> requestHead = req.getHeaderNames();
        while (requestHead.hasMoreElements()) {
            String key = requestHead.nextElement();
            /*String value = req.getHeader(key);
            sb.append(key + ": " + value + "<br>");*/
            sb.append(key + "<br>");
        }

        resp.setContentType("text/html; charset=utf8");
        sb.append(req.getCharacterEncoding()+ "<br>");
        sb.append(req.getContentLength() + "<br>");
        //告诉浏览器, 我们的数据是什么类型的

        //把上述字符串中的内容返回到客户端
        resp.getWriter().write(sb.toString());
    }
}