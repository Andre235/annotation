package com.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * @author : 赵静超
 * @date : 2019/10/11 16:44
 * @description : 日志切面类(将业务逻辑类与日志记录类解耦)
 *                添加@Aspect注解，告诉spring容器这是一个切面类
 */
@Aspect
public class LogAspects {

    //抽取公共的切入点表达式
    @Pointcut(value = "execution(public int com.AOP.Calculator.*(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        //获取参数列表
        Object[] args = joinPoint.getArgs();
        //获取方法名称
        String funcName = joinPoint.getSignature().getName();
        System.out.println(funcName+"()开始运行，参数是："+ Arrays.asList(args));
    }

    @After("pointCut()")
    public void logEnd(){
        System.out.println("除法运行结束");
    }

    //JoinPoint一定要放在第一个参数位置上
    @AfterReturning(value = "pointCut()",returning = "result")
    public void logReturn(JoinPoint joinPoint,Object result){
        //获取方法名称
        String funcName = joinPoint.getSignature().getName();
        System.out.println(funcName+"除法正常退出，返回值是:"+result);
    }

    @AfterThrowing(value = "pointCut()",throwing = "exception")
    public void logException(Exception exception){
        System.out.println("除法出现异常，异常信息为：" +exception.getMessage());
    }
}
