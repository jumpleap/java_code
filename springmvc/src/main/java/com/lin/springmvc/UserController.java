package com.lin.springmvc;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {
    // RequestMapping: 将程序和浏览器进行建立连接(建立连接)
    @RequestMapping("/say")
    public String say() {
        return "say Hi!";
    }

    // 指定访问的请求方式, 指定say2的访问方式是Get方法
    // 当只有一个属性的时候, 可以省略, 当有两个及以上的属性时, 那么需要把相关的属性名也写上
    @RequestMapping(value = "/say2", method = RequestMethod.GET)
    public String say2() {
        return "say Hi!";
    }

    // 传递单个参数
    @RequestMapping("/r1")
    public String r1(String name) {
        return "接受到参数: " + name;
    }

    // 传递多个参数
    // 注: 参数顺序不分先后
    @RequestMapping("/r2")
    public String r2(String name, Integer age) {
        return "name : " + name + ", age : " + age;
    }

    // 传递对象
    @RequestMapping("/r3")
    public String r3(UserInfo user) {
        return user.toString();
    }

    // 参数重命名: @RequestParam(新名)
    // 从请求中获取的name的参数, 然后赋值给userName的参数
    // RequestParam是默认必须传参的, required = false既修改
    @RequestMapping("/r4")
    public String r4(@RequestParam(value = "name", required = false) String userName, Integer age) {
        return "name:" + userName + ", age:" + age;
    }

    // 传递数组
    @RequestMapping("/r5")
    public String r5(String[] arr) {
        return Arrays.toString(arr) + ", arr.length = " + arr.length;
    }

    // 传递集合: 需要使用RequestParam绑定参数, 否则会按照数组的方式传递
    @RequestMapping("/r6")
    public String r6(@RequestParam List<String> list) {
        return list.toString() + ", list.size = " + list.size();
    }

    // 传递Json字符串: 需要使用RequestBody
    @RequestMapping("/r7")
    public String r7(@RequestBody UserInfo userInfo) {
        return userInfo.toString();
    }

    // 获取URL中的参数: @PathVariable绑定参数: 请求URL路径上的数据绑定
    // @PathVariable是必须要传的参数, 若不想则需要把required置为false
    @RequestMapping("/r8/{article}")
    public String r8(@PathVariable Integer article) {
        return "article:" + article;
    }

    @RequestMapping("/r9/{name}/{age}")
    public String r9(@PathVariable(value = "name", required = false) String userName, @PathVariable("age") int userAge) {
        return "name:" + userName + ", age:" + userAge;
    }

    // 上传文件: @RequestPart
    @RequestMapping("/r10")
    public String r10(@RequestPart MultipartFile file) throws IOException {
        // 获取文件名+后缀
        String name = file.getOriginalFilename();
        file.transferTo(new File("d:/" + name));
        return "获取的文件名: " + name;
    }

    /*
     1.错误日志从下往上看, 一段一段看
     2.出现错误先观察状态码
        1)如果是404, 先确认url是否存在
        2)如果是5xx, 先去看后端控制台日志
     */
}
