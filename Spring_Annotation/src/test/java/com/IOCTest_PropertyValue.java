package com;

import com.bean.Person;
import com.config.MyConfig_PropertyValue;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author : 赵静超
 * @date : 2019/10/11 14:16
 * @description : @Value注解测试类
 *                使用@Value对 对象的字段进行赋值
 *                   Value("张三")
 *                   Value("#{20-2}")  spring表达式
 *                   Value("&{ }")     取值配置文件中的数值
 */
public class IOCTest_PropertyValue {

    //基于注解的方式进行配置
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig_PropertyValue.class);

    @Test
    public void testValue(){
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("-------------输出person对象-------------");
        //获取person对象，参数为bean的id (方法名即为bean对象的id)，返回Object对象，需要进行强制转换
        Person bean = (Person)context.getBean("person");
        System.out.println(bean);
        System.out.println("使用方法进行获取配置文件中的值");

        ConfigurableEnvironment environment = context.getEnvironment();
        String nickName = environment.getProperty("person.nickName");
        String os = environment.getProperty("os.name");
        System.out.println("系统环境为："+os);
        System.out.println("配置文件中nickName为："+nickName);
    }

}
