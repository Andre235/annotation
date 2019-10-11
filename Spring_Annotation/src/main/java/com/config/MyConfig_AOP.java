package com.config;

import com.AOP.Calculator;
import com.AOP.LogAspects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author : 赵静超
 * @date : 2019/10/11 16:34
 * 面向切面编程AOP：[动态代理思想]
 *      1、导入相应依赖:spring-aspects
 *      2、定义一个业务逻辑类Calculator.class,在业务逻辑运行的时候进行日志打印(程序运行之前，程序运行之后，程序出现异常时.....)
 *      3、定义一个日志切面类AOPAsPects类，需要动态感知业务逻辑类除法运行到哪一步骤，接着调用相应的方法进行通知操作
 *      4、通知方法:
 *          前置通知 @Before：
 *          后置通知 @After： 在目标方法运行之后执行(无论是正常结束，还是异常结束)
 *          返回通知 @AfterReturning：目标方法正常返回后执行
 *          异常通知 @AfterThrowing： 目标方法出现异常时执行
 *          环绕通知 @Around： 动态代理思想，手动推进目标方法执行
 *       5、给切面类的目标方法的通知方法添加相应注解
 *       6、将切面类和目标业务逻辑类添加到spring容器中
 *       7、添加相应注解，告诉spring容器哪个是切面类 @Aspect
 *       8、@EnableAspectJAutoProxy 开启基于注解的aop
 *
 *     AOP案例步骤：
 *          1、将业务逻辑组件和切面类注入到spring容器中，告诉容器哪个是切面类@Aspect
 *          2、在切面类中的通知方法上添加相应的注解，告诉容器通知方法的切入点时间
 *          3、开启基于注解AOP模式 @EnableAspectJAutoProxy
 */
@EnableAspectJAutoProxy //开启基于注解的aop
@Configuration
public class MyConfig_AOP {

    //将业务逻辑类注入到spring容器中
    @Bean
    public Calculator calculator(){
        return new Calculator();
    }

    //将切面类注入到spring容器中
    @Bean
    public LogAspects logAspects(){
        return new LogAspects();
    }
}
