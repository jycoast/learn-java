package org.jyc.thinking.in.spring.conversion;

import org.jyc.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.stereotype.Component;

/**
 * 自定义{@link org.springframework.beans.PropertyEditorRegistrar} 实现
 *
 * @author jiyongchao
 */
// @Component // 3.将其声明为Spring Bean
public class CustomizedPropertyEditorRegistrar implements PropertyEditorRegistrar {
    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        // 1.通用类型转换
        // 2.Java Bean属性类型转换
        registry.registerCustomEditor(User.class, "context", new StringToPropertiesPropertyEditor());

    }
}
