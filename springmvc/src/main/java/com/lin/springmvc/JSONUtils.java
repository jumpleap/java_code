package com.lin.springmvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

// 对象与json字符串的互相转化
public class JSONUtils {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
//        UserInfo user = new UserInfo();
//        user.setAge(12);
//        user.setId("21");
//        user.setName("zhangsan");

        UserInfo user = new UserInfo("zhangsan", 12, "12");

        // 对象转化为json字符串
        String string = objectMapper.writeValueAsString(user);
        System.out.println(string);

        // json字符串转化为对象
        UserInfo userInfo = objectMapper.readValue(string, UserInfo.class);
        System.out.println(userInfo);
    }
}