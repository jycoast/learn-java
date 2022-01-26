package org.jyc.thinking.in.spring.validation;

import org.jyc.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.springframework.context.MessageSource;
import org.springframework.context.support.StaticMessageSource;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.Locale;

/**
 * 错误文案示例
 *
 * @author jiyongchao
 */
public class ErrorMessageDemo {
    public static void main(String[] args) {
        // 1.创建User对象
        User user = new User();
        user.setName("jiyongchao");
        // 2.选择Errors - BeanPropertyBindingResult
        Errors errors = new BeanPropertyBindingResult(user, "user");
        // 3.调用reject或者rejectValue
        // reject生成ObjectError
        // reject生成 FildError
        errors.reject("user.properties.not.null");
        errors.rejectValue("name", "name.required");
        //4.FieldError is ObjectError
        List<ObjectError> globalErrors = errors.getGlobalErrors();
        FieldError fieldError = errors.getFieldError();
        List<ObjectError> allErrors = errors.getAllErrors();
        // 5.通过ObjectError和FieldError中的code和args关联MessageSource实现
        MessageSource messageSource = createMessageSource();

        for (ObjectError error : allErrors) {
            messageSource.getMessage(error.getCode(), error.getArguments(), Locale.getDefault());
            System.out.println(messageSource);
        }
    }

     static MessageSource createMessageSource() {
        StaticMessageSource staticMessageSource = new StaticMessageSource();
        staticMessageSource.addMessage("user.properties.not.null", Locale.getDefault(), "User 属性不能为空");
        staticMessageSource.addMessage("name.required", Locale.getDefault(), "name is not null");
        staticMessageSource.addMessage("id.required", Locale.getDefault(), "id is not null");
        return staticMessageSource;
    }
}
