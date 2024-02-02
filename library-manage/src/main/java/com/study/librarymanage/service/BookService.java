package com.study.librarymanage.service;

import com.study.librarymanage.dao.BookDao;
import com.study.librarymanage.model.BookInfo;

import java.util.List;

public class BookService {
    /**
     * 根据数据层返回的结果对数据进行处理
     * @return
     */
    public List<BookInfo> getBookList() {
        // 从Dao拿数据
        BookDao bookDao = new BookDao();
        List<BookInfo> bookInfos = bookDao.mockData();
        // 对数据进行处理
        for (BookInfo bookInfo : bookInfos) {
            if (bookInfo.getStatus() == 1) {
                bookInfo.setStatusCN("可借阅");
            } else if (bookInfo.getStatus() == 2) {
                bookInfo.setStatusCN("不可借阅");
            }
        }
        return bookInfos;
    }
}
