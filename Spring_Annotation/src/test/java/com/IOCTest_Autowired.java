package com;

import com.config.MyConfig_Autowired;
import com.dao.BookDao;
import com.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : 赵静超
 * @date : 2019/10/11 15:44
 * @description :
 */

public class IOCTest_Autowired {

    @Test
    public void testAutoWired(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig_Autowired.class);
        BookService bookService = context.getBean(BookService.class);
        BookDao bookDao = context.getBean(BookDao.class);
        System.out.println(bookDao);
        System.out.println(bookService);


    }
}
