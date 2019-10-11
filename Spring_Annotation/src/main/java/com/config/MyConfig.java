package com.config;

import com.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @author : 赵静超
 * @date : 2019/10/10 12:03
 * @description : 配置文件-->配置类
 */
@Configuration  //告诉spring这是一个配置类
@ComponentScan(value = "com",
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class, Service.class})},useDefaultFilters = false) //排除指定注解定义的类，进行包扫描到spring容器中
//@ComponentScan(value = " ") 指定要扫描的包的路径
//excludeFilters = Filter{ }  指定要进行排除扫描的类
//includeFilters = Filter{ }  指定要进行扫描的类 ,useDefaultFilters = false
public class MyConfig {

    /**
     * 给容器中注册一个Bean
     * 类型为返回值类型
     * id为方法名称
     * @return
     */
    @Bean("Person")
    public Person person01(){
        return new Person("andre",18);
    }
}
