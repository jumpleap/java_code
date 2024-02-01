package com.study.librarymanage;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RequestMapping("/user")
@RestController
public class UserController {
    @RequestMapping("/login")
    public boolean login(String username, String password, HttpSession session) {
        // 判断username和password是否为null或为空串
        if (!StringUtils.hasLength(username) || !StringUtils.hasLength(password)) {
            return false;
        }
        // 校验账号和密码
        if ("admin".equals(username) && "admin".equals(password)) {
            // 创建会话
            session.setAttribute("username", username);
            return true;
        }
        return false;
    }
}
