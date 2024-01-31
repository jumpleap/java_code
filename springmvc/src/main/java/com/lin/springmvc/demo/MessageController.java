package com.lin.springmvc.demo;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

// 留言墙案例
@RequestMapping("/message")
@RestController
public class MessageController {
    private List<MessageInfo> messageInfos = new ArrayList<>();

    @RequestMapping("/publish")
    public boolean publish(MessageInfo messageInfo) {
        // 打印日志, 防止报错找不到北
        System.out.println(messageInfo);

        // 检查from, to, message 的值是否为null或空串
        if (StringUtils.hasLength(messageInfo.getFrom())
            && StringUtils.hasLength(messageInfo.getTo())
            && StringUtils.hasLength(messageInfo.getMessage())) {
            messageInfos.add(messageInfo);
            return true;
        }
        return false;
    }

    @RequestMapping("/getList")
    public List<MessageInfo> getList() {
        return messageInfos;
    }
}
