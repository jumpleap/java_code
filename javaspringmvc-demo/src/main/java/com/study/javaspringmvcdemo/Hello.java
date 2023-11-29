package com.study.javaspringmvcdemo;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String sayHi() {
        return "Hi";
    }

    @RequestMapping("/f1")
    public String f1(User user) {
        if (user != null) {
            return user.toString();
        }
        return "null";
    }

    @RequestMapping("/f2")
    public String f2(@RequestBody User user) {
        if (user != null) {
            return user.toString();
        }
        return "null";
    }
}