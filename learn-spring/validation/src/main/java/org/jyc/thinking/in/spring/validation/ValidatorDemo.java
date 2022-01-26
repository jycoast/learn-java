package org.jyc.thinking.in.spring.validation;

import org.jyc.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.springframework.context.MessageSource;
import org.springframework.validation.*;

import java.util.Locale;

import static org.jyc.thinking.in.spring.validation.ErrorMessageDemo.createMessageSource;

/**
 * 自定义Spring{@link org.springframework.validation.Validator} 示例
 *
 * @author jiyongchoa
 */
public class ValidatorDemo {

    public static void main(String[] args) {
        // 1.创建Validator
        Validator validator = new UserValodator();
        // 2.判断是否支持目标对象的类型
        User user = new User();
        System.out.println(validator.supports(user.getClass()));
        // 3.创建Errors对象
        Errors errors = new BeanPropertyBindingResult(user, "user");
        validator.validate(user, errors);
        // 4.获取MessageSource对象
        MessageSource messageSource = createMessageSource();
        // 5.输出所有的错误文案
        for (ObjectError error : errors.getAllErrors()) {
            String message = messageSource.getMessage(error.getCode(), error.getArguments(), Locale.getDefault());
            System.out.println(message);
        }
    }

    static class UserValodator implements Validator {
        @Override
        public boolean supports(Class<?> clazz) {
            return User.class.equals(clazz);
        }

        @Override
        public void validate(Object target, Errors errors) {
            User user = (User) target;
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "id.required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");
            String name = user.getName();
            // ...
        }
    }
}
