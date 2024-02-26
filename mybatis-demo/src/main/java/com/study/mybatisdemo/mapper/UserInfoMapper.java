package com.study.mybatisdemo.mapper;

import com.study.mybatisdemo.controller.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserInfoMapper {
    // 查询所有用户
    @Select("select username, `password`, age, gender, phone from userinfo")
    public List<UserInfo> queryAllUser();

    // 查询固定的id, 不建议
    @Select("select username, `password`, age, gender, phone from userinfo where id = 4")
    UserInfo queryById();

    // 通过给定的id查询用户
    @Select("select id, username, `password`, age, gender, phone from userinfo where id = #{id}")
    UserInfo queryById2(Integer id);

    // 通过@Param设置别名, #{}中的名字必须和别名一致
    @Select("select id, username, `password`, age, gender, phone from userinfo where id = #{userid}")
    UserInfo queryById3(@Param("userid")Integer id);

    // 添加
    @Insert("insert into userinfo (username, `password`, age, gender, phone) " +
            "values(#{username}, #{password}, #{age}, #{gender}, #{phone})")
    Integer insert(UserInfo userInfo);


    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into userinfo (username, age, gender, phone) " +
            "values (#{username}, #{password}, #{age}, #{gender}, #{phone})")
    Integer insert2(UserInfo userInfo);
}
