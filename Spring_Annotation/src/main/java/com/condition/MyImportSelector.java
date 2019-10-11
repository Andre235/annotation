package com.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author : 赵静超
 * @date : 2019/10/10 16:54
 * @description : 自定义逻辑,返回需要导入的组件
 */
public class MyImportSelector implements ImportSelector {
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"com.bean.Blue","com.bean.Yellow"};
    }
}
