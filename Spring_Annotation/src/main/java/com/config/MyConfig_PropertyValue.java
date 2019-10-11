package com.config;

import com.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author : 赵静超
 * @date : 2019/10/11 14:14
 * @description : @Value注解配置类
 */
@PropertySource(value = {"classpath:/person.properties"}) //该注解作用：加载外部配置文件中值key：value保存到运行的环境变量中
@Configuration
public class MyConfig_PropertyValue {

    @Bean
    public Person person(){
        return new Person();
    }
}

