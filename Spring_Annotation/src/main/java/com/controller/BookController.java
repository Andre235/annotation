package com.controller;

import com.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author : 赵静超
 * @date : 2019/10/10 14:03
 * @description :
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;
}
