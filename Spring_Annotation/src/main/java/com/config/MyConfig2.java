package com.config;

import com.condition.LinuxCondition;
import com.condition.MyImportSelector;
import com.condition.WindowsCondition;
import com.bean.Color;
import com.bean.Person;
import com.bean.Red;
import org.springframework.context.annotation.*;

/**
 * @author : 赵静超
 * @date : 2019/10/10 15:13
 * @description :
 */
@Configuration
@Import({Color.class, Red.class, MyImportSelector.class})
public class MyConfig2 {


    @Lazy
    @Scope("singleton")
    @Bean("person")
    public Person person(){
        System.out.println("在容器中添加person......");
        return  new Person("Natasha",20);
    }

    /**
     * @Conditional 按照一定的判断条件，将对象注入到spring容器中
     *
     * windows系统则注入bill对象；linux系统则注入linus对象
     */
    @Conditional({WindowsCondition.class})
    @Bean("bill")
    public Person person01(){
        return new Person("bill gates",62);
    }

    @Conditional({LinuxCondition.class})
    @Bean("linus")
    public Person person02(){
        return new Person("linus",48);
    }

}
