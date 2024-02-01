package com.study.librarymanage;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RequestMapping("/book")
@RestController
public class BookController {
    @RequestMapping("/getList")
    public List<BookInfo> getList() {
        // 处理数据, 用于页面展示
        List<BookInfo> bookInfos = mockData();

        for (BookInfo book : bookInfos) {
            if (book.getStatus() == 1) {
                book.setStatusCN("可借阅");
            } else {
                book.setStatusCN("不可借阅");
            }
        }
        return bookInfos;

    }

    /**
     * 使用mock构造数据, 用于验证
     * @return
     */
    public List<BookInfo> mockData() {
        List<BookInfo> bookInfos = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            BookInfo bookInfo = new BookInfo();
            bookInfo.setId(i);
            bookInfo.setBookName("书籍" + i);
            bookInfo.setAuthor("作者" + i);
            bookInfo.setCount(i * 5 + 3);
            bookInfo.setPrice(new BigDecimal(new Random().nextInt(100)));
            bookInfo.setPublish("出版社" + i);
            bookInfo.setStatus(i % 2);
            bookInfos.add(bookInfo);
        }
        return bookInfos;
    }
}
