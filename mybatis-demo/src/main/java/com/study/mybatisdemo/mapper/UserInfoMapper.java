package com.study.mybatisdemo.mapper;

import com.study.mybatisdemo.model.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserInfoMapper {
    // 查
    // 查询所有用户
    @Select("select username, `password`, age, gender, phone from userinfo")
    List<UserInfo> queryAllUser();

    // 查询所有字段的内容
    // @Select("select * from userinfo")
    @Select("select username, `password`, age, gender, phone, " +
            "delete_flag, create_time, update_time from userinfo")
    List<UserInfo> queryAllUser2();

    // 上述查询无法查询到删除标志(deleteFlag), 创建时间(createTime), 更新时间(updateTime)字段
    // 我们使用以下三种方法来进行查询这三个字段
    // 1.起别名
    @Select("select id, username, `password`, age, gender, phone, " +
            "delete_flag as deleteFlag, create_time as createTime, update_time as updateTime" +
            " from userinfo")
    List<UserInfo> queryAllUser3();

    // 2.结果映射
    @Select("select id, username, `password`, age, gender, phone, " +
            "delete_flag, create_time, update_time from userinfo")
    // 复用Results
    @Results(id = "resultMap", value = {
            @Result(column = "delete_flag", property = "deleteFlag"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime"),
    })
    List<UserInfo> queryAllUser4();

    // 3.配置驼峰命名
    @Select("select id, username, `password`, age, gender, phone, " +
            "delete_flag, create_time, update_time from userinfo")
    List<UserInfo> queryAllUser5();

    // 查询固定的id, 不建议
    @Select("select username, `password`, age, gender, phone from userinfo where id = 4")
    UserInfo queryById();

    // 通过给定的id查询用户
    @Select("select id, username, `password`, age, gender, phone from userinfo where id = #{id}")
    UserInfo queryById2(Integer id);

    // 通过@Param设置别名, #{}中的名字必须和别名一致
    @Select("select id, username, `password`, age, gender, phone from userinfo where id = #{userid}")
    UserInfo queryById3(@Param("userid") Integer id);

    // 复用Results
    @Select("select id, username, `password`, age, gender, phone, delete_flag, " +
            "create_time, update_time from userinfo where id = #{userid}")
    @ResultMap(value = "resultMap")
    UserInfo queryById4(@Param("userid") Integer id);

    // 添加
    @Insert("insert into userinfo (username, `password`, age, gender, phone) " +
            "values(#{username}, #{password}, #{age}, #{gender}, #{phone})")
    Integer insert(UserInfo userInfo);


    // @Options: 帮助我们拿到自增主键的id
    // useGeneratedKeys: MyBatis使用JDBC的getGeneratedKeys方法来取出由数据库内部生成的主键, 默认值: false
    // keyProperty: 指定能够唯一识别对象的属性, 默认值: 未设置(相当于把id赋值给keyProperty中的id)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into userinfo (username, password, age, gender, phone) " +
            "values (#{username}, #{password}, #{age}, #{gender}, #{phone})")
    Integer insert2(UserInfo userInfo);


    // 删除
    @Delete("delete from userinfo where id = #{id}")
    void delete(Integer id);

    // 改(update)
    @Update("update userinfo set username = #{username} where id = #{id}")
    void update(UserInfo userInfo);

}
