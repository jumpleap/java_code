package com.study.librarymanage.dao;

import com.study.librarymanage.model.BookInfo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BookDao {
    public List<BookInfo> mockData() {
        List<BookInfo> books = new ArrayList<>();

        // 构造数据
        for (int i = 1; i <= 15; i++) {
            BookInfo bookInfo = new BookInfo();
            bookInfo.setId(i);
            bookInfo.setBookName("书名" + i);
            bookInfo.setAuthor("作者" + i);
            bookInfo.setCount(i * 5 + 3);
            bookInfo.setPrice(new BigDecimal(new Random().nextInt(100)));
            bookInfo.setPublish("出版色" + i);
            bookInfo.setStatus(i % 2 == 0 ? 1 : 2);

            books.add(bookInfo);
        }
        return books;
    }
}
