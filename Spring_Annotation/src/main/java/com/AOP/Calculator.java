package com.AOP;

/**
 * @author : 赵静超
 * @date : 2019/10/11 16:38
 * @description : 业务逻辑类
 */
public class Calculator {

    public int division(int i,int j){
        System.out.println("div方法被调用.....");
        System.out.println("test");
        return i/j;
    }


}
