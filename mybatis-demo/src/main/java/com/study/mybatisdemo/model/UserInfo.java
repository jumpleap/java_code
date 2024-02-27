package com.study.mybatisdemo.model;

import lombok.Data;

import java.util.Date;

@Data
public class UserInfo {
    private Integer id; // 用户id
    private String username; // 用户名
    private String password; // 密码
    private Integer age; // 年龄
    private Integer gender; // 性别: 1-男, 2-女, 0-默认
    private String phone; // 电话号码
    private Integer deleteFlag; // 删除标志: 0-正常, 1-删除
    private Date createTime;
    private Date updateTime;
}
