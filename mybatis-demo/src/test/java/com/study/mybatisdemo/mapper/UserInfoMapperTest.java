package com.study.mybatisdemo.mapper;

import com.study.mybatisdemo.controller.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserInfoMapperTest {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    void queryAllUser() {
        // 获取queryAllUser中的所有数据, 然后打印出来
        List<UserInfo> list = userInfoMapper.queryAllUser();
        System.out.println(list);
    }

    @Test
    void queryById() {
        System.out.println(userInfoMapper.queryById().toString());
    }

    @Test
    void queryById2() {
        System.out.println(userInfoMapper.queryById2(1));
    }

    @Test
    void queryById3() {
        System.out.println(userInfoMapper.queryById3(1));
    }

    @Test
    void insert() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("zhaoliu");
        userInfo.setPassword("zhaoliu");
        userInfo.setAge(18);
        userInfo.setGender(1);
        userInfo.setPhone("183672573578");

        userInfoMapper.insert(userInfo);
    }
}