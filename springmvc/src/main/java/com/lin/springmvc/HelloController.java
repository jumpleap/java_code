package com.lin.springmvc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// RequestMapping既可以做类注解, 也可以做方法注解
// RequestMapping既可以使用Get(通过浏览器访问)方法, 也可以使用Post方法
// @RequestMapping("/demo")
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        return "hello, spring!";
    }
}
