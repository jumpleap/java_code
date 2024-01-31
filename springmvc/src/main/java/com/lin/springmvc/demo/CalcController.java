package com.lin.springmvc.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 计算器案例
@RequestMapping("/calc")
@RestController
public class CalcController {
    @RequestMapping("/sum")
    public String add(Integer num1, Integer num2) {
        Integer sum = num1 + num2;
        return "计算结果为:" + sum;
    }
}
