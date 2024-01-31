package com.lin.springmvc;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

@RequestMapping("/cas")
@RestController
public class CookieAndSession {
    // 获取Cookie(传统方式)
    @RequestMapping("/getcookie")
    public String getCookie(HttpServletRequest request) {
        // 获取所有cookie
        Cookie[] cookies = request.getCookies();
        //Arrays.stream(cookies).forEach(x -> System.out.println(x.getName() + ":" + x.getValue()));
        if (cookies != null) {
            for (Cookie c : cookies) {
                System.out.println(c.getName() + ":" + c.getValue());
            }
            return "cookie获取成功!";
        }
        return "cookie获取失败!";
    }

    // 获取cookie(简洁方式)
    @RequestMapping("/getcookie2")
    public String getCookie(@CookieValue("bite") String bite) {
        return "bite:" + bite;
    }


    // 获取Session
    @RequestMapping("/getSession1")
    public String getSess(HttpServletRequest request) {
        // 默认值为true, 如果session为null, 就创建一个空的session
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        return "登录用户:" + username;
    }

    @RequestMapping("/getSession2")
    public String getSession(HttpSession session) {
        String username = (String) session.getAttribute("username");
        return "登录用户: " + username;
    }

    @RequestMapping("/getSession3")
    public String getSession(@SessionAttribute(value = "userName", required = false) String userName) {
        return "登录用户: " + userName;
    }

    // 获取header
    @RequestMapping("/getHeader")
    public String getHeader(HttpServletRequest request) {
        String header = request.getHeader("User-Agent");
        return "userAgent:" + header;
    }

    // 第二种方式
    @RequestMapping("/getHeader2")
    public String getHeader2(@RequestHeader("User-Agent") String userAgent) {
        return "userAgent:" + userAgent;
    }
}
