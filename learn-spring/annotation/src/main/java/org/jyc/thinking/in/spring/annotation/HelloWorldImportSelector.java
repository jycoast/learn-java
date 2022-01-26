package org.jyc.thinking.in.spring.annotation;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * HelloWorld模块{@link org.springframework.context.annotation.ImportSelector}实现
 *
 * @author jiyongchao
 */
public class HelloWorldImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"org.jyc.thinking.in.spring.annotation.HelloWorldConfiguration"};
    }
}
