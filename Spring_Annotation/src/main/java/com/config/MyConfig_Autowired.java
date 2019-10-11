package com.config;

import com.bean.Person;
import com.dao.BookDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author : 赵静超
 * @date : 2019/10/11 14:14
 * Autowired注解的使用
 */
@Configuration
@ComponentScan({"com.controller","com.dao","com.service"})
public class MyConfig_Autowired {

    @Bean("bookDao2")
    public BookDao bookDao(){
        BookDao bookDao = new BookDao();
        bookDao.setLable("2");
        return new BookDao();
    }
}

