package com.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author : 赵静超
 * @date : 2019/10/10 11:14
 * @description :
 *                 1.配置方式开发
 */

public class Person {

    @Value("张三")
    private String name;
    @Value("#{22-2}")
    private Integer age;
    @Value("${person.nickName}")
    private String nickName; //昵称

    public Person() {
    }
    public Person(String name,Integer age) {
        this.name=name;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
