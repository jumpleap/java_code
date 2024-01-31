package com.lin.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/return")
@Controller
public class ReturnController {
    // 返回静态页面
    @RequestMapping("/r1")
    public String r1() {
        return "/calc.html";
    }

    // 元注解解释
    // @Target({ElementType.TYPE}):  表示注解的使用范围
    //@Retention(RetentionPolicy.RUNTIME): 表示注解的生命周期

    // 返回数据: 响应中的正文部分
    // 返回静态页面
    @ResponseBody
    @RequestMapping("/r2")
    public String r2() {
        return "/calc.html";
    }
    // 注: RestController = Controller + ResponseBody


    // 返回HTML片段
    @ResponseBody
    @RequestMapping("/r3")
    public String r3() {
        return "<h3>这是一个HTML片段<h3>";
    }

    // 返回Json
    @ResponseBody
    @RequestMapping("/r4")
    public UserInfo r4() {
        UserInfo userInfo = new UserInfo("xiao", 13, "1");
        return userInfo;
    }

    @ResponseBody
    @RequestMapping("/r5")
    public Map<String, String> r5() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "张三");
        map.put("2", "李四");
        return map;
    }

    // 返回js, css
    @RequestMapping("/r6")
    public String r6() {
        return "/a.js";
    }

    @RequestMapping("/r7")
    public String r7() {
        return "/b.css";
    }

    // 设置状态码
    @ResponseBody
    @RequestMapping("/r8")
    public String r8(HttpServletResponse response) {
        response.setStatus(203);
        return "设置状态码成功!";
    }

    // 设置Content-Type
    @ResponseBody
    @RequestMapping("/r9")
    public String r9() {
        return "1233";
    }

    @ResponseBody
    @RequestMapping(value = "/r10", produces = "application/json;charset=utf8")
    public String r10() {
        return "1233";
    }

    // 自定义header
    @RequestMapping("/r11")
    @ResponseBody
    public String r11(HttpServletResponse response) {
        response.setHeader("myHeadr", "hi,header");
        return "设置header成功!";
    }
}
