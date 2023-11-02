import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

class Request {
    public String username;
    public String password;
}

class Response {
    public boolean ok;
}

@WebServlet("/jsonParameter")
public class JsonParameterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //此处约定请求格式如下:
        //POST /json
        //Content-Type: application/json
        //{
        //  username: "zhangsan",
        //  password: "123
        //}

        //此处也约定响应格式(也按照json来组织)
        //{
        //  ok: true
        //}

        //把请求的body的json格式转换为Java的对象
        ObjectMapper objectMapper = new ObjectMapper();
        Request request = objectMapper.readValue(req.getInputStream(), Request.class);
        System.out.println("username:" + request.username);
        System.out.println("password: " + request.password);

        //resp.getWriter().write("ok");
        Response response = new Response();
        response.ok = true;
        //把响应对象转化为json字符串
        String respJson = objectMapper.writeValueAsString(response);
        resp.setContentType("application/json; charset=utf8");
        resp.getWriter().write(respJson);
    }
}
