package com.study.librarymanage.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RequestMapping("/user")
@RestController
public class UserController {
    @RequestMapping("/login")
    public boolean login(String username, String password, HttpSession session) {
        // 有null或空串则返回false
        if (!StringUtils.hasLength(username) || !StringUtils.hasLength(password)) {
            return false;
        }
        // 检验账号密码是否正确
        if ("admin".equals(username) && "admin".equals(password)) {
            // 账号和密码正确, 建立会话
            session.setAttribute("username", username);
            return true;
        }
        // 账号和密码有一个不正确
        return false;
    }
}