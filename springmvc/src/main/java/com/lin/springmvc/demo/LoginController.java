package com.lin.springmvc.demo;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 登录案例
@RestController
@RequestMapping("/user")
public class LoginController {
    /**
     * 检查用户名和密码是否正确, 是否为空, 正确则创建会话
     * @param username
     * @param password
     * @param session
     * @return
     */
    @RequestMapping("/login")
    public boolean login(String username, String password, HttpSession session) {
        // 账号或密码错误
        if (!StringUtils.hasLength(username) || !StringUtils.hasLength(password)) {
            return false;
        }

        // 校验密码和账户是否正确
        if (!"zhangsan".equals(username) || !"123456".equals(password)) {
            return false;
        }
        // 密码验证成功, 把用户名存储在Session中
        session.setAttribute("username", username);
        return true;
    }

    // 获取当前登录的对象
    @RequestMapping("/getLoginUser")
    public String getLoginUser(HttpSession session) {
        // 从session中获取当前登录的用户信息
        String username = (String) session.getAttribute("username");
        // 有用户直接返回当前用户名
        if (StringUtils.hasLength(username)) {
            return username;
        }
        return "";
    }
}
