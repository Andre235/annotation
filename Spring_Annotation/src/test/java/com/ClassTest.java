package com;

import com.config.MyConfig;
import com.config.MyConfig2;
import com.bean.Person;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

/**
 * @author : 赵静超
 * @date : 2019/10/10 11:58
 * @description :
 */
public class ClassTest {

    private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig2.class);

    /**
     * 基于xml配置文件的方式进行配置
     */
    @Test
    public void test01() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Person bean = (Person) applicationContext.getBean("person");
        System.out.println(bean);
    }

    /**
     * 基于注解的方式进行配置
     */
    @Test
    public void test02() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Person bean = context.getBean(Person.class);
        System.out.println(bean);
        String[] names = context.getBeanNamesForType(Person.class);  //获取bean的id
        for (String name : names) {
            System.out.println(name);
        }
    }

    /**
     * 查看当前容器中有注入了哪些组件
     */
    @Test
    public void test03(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

    /**
     * 查看当前容器中有注入了哪些组件
     */
    @Test
    public void test04(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig2.class);
        /*String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }*/

        //spring框架默认是单例模式
        System.out.println("IOC容器创建完成......");
        Object bean = context.getBean("person");
        Object bean1 = context.getBean("person");
        //System.out.println(bean==bean1); //因此 bean地址=bean1地址

    }

    @Test
    public void test05(){
        //获取当前环境的操作系统名称
        ConfigurableEnvironment environment = context.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property);
        //获取所有对象id
        String[] names = context.getBeanNamesForType(Person.class);
        for (String name : names) {
            System.out.println(name);
        }
        //获取所有对象
        Map<String, Person> personMap = context.getBeansOfType(Person.class);
        System.out.println(personMap);
    }

    /**
     * 测试@Import({Color.class, Red.class})
     */
    @Test
    public void testImport(){
        String[] beanDefinitionNames = context.getBeanDefinitionNames();  //获取注入的bean的名称
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }

}
