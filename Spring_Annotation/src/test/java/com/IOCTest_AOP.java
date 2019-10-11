package com;

import com.AOP.Calculator;
import com.config.MyConfig_AOP;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : 赵静超
 * @date : 2019/10/11 15:44
 * @description :
 */

public class IOCTest_AOP {

    @Test
    public void testAutoWired(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig_AOP.class);
        Calculator calculator = context.getBean(Calculator.class);
        calculator.division(1,1);
    }
}
