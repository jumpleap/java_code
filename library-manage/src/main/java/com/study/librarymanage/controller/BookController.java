package com.study.librarymanage.controller;

import com.study.librarymanage.dao.BookDao;
import com.study.librarymanage.model.BookInfo;
import com.study.librarymanage.service.BookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RequestMapping("/book")
@RestController
public class BookController {
    @RequestMapping("/getList")
    public List<BookInfo> getList() {
        // 对数据进行处理
        BookService bookService = new BookService();
        List<BookInfo> bookInfos = bookService.getBookList();
        return bookInfos;
    }
}
