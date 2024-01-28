package com.lin.springmvc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloCN {
    @RequestMapping("hello2")
    public String hello2() {
        return "你好, spring!";
    }
}
