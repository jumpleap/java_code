package com.study.mybatisdemo.mapper;

import com.study.mybatisdemo.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

    @Test
    void insert2() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("wangwu");
        userInfo.setPassword("123456");
        userInfo.setGender(2);
        userInfo.setAge(21);
        userInfo.setPhone("163757548864");

        Integer count = userInfoMapper.insert2(userInfo);
        System.out.println("添加数据条数:" + count + ", 数据ID: " + userInfo.getId());
    }

    @Test
    void delete() {
        userInfoMapper.delete(10);
    }


    @Test
    void update() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(5);
        userInfo.setUsername("Jerry");
        userInfoMapper.update(userInfo);
    }

    @Test
    void queryAllUser2() {
        System.out.println(userInfoMapper.queryAllUser2().toString());
    }

    @Test
    void queryAllUser3() {
        List<UserInfo> userInfoList = userInfoMapper.queryAllUser3();
        System.out.println(userInfoList);
    }

    @Test
    void queryAllUser4() {
        List<UserInfo> userInfoList = userInfoMapper.queryAllUser4();
        System.out.println(userInfoList);
    }

    @Test
    void queryById4() {
        UserInfo userInfo = userInfoMapper.queryById4(1);
        System.out.println(userInfo);
    }

    @Test
    void queryAllUser5() {
        System.out.println(userInfoMapper.queryAllUser5().toString());
    }
}