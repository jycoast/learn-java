package org.jyc.thinking.in.spring.data.binding;

import org.jyc.thinking.in.spring.ioc.overview.dependency.domain.Company;
import org.jyc.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import java.util.HashMap;

/**
 * {@link org.springframework.validation.DataBinder} 实例
 *
 * @author jiyongchao
 */
public class DataBinderDemo {
    public static void main(String[] args) {
        // 创建空白对象
        User user = new User();
        // 1.创建DataBinder
        DataBinder dataBinder = new DataBinder(user, "user");

        // 2.创建PropertyValues
        HashMap<String, Object> source = new HashMap<>();
        source.put("id", "1");
        source.put("name", "吉永超");

        // a.PropertyValues存在user中不存在的属性值
        // DataBinder特性一：忽略了未知的属性
        source.put("age", 18);

        // b.PropertyValues存在一个嵌套属性，company.name
        // DataBinder特性二：支持嵌套属性
        source.put("company.name", "jjjj");

//        source.put("company", new Company());
//        source.put("company.name","jjjj");

        MutablePropertyValues propertyValues = new MutablePropertyValues(source);

        // 1.调整ignoreUnknownFields true（默认） -> false
//        dataBinder.setIgnoreUnknownFields(false);

        // 2.调整自动增加嵌套路径true（默认） -> false
        dataBinder.setAutoGrowNestedPaths(false);

        // 3.调整ignoreInvalidFields false（默认） -> true
        dataBinder.setIgnoreInvalidFields(true);

        // 4.白名单
        dataBinder.setRequiredFields("id", "name", "city");

        dataBinder.bind(propertyValues);
        // 输出user
        System.out.println(user);

        // 5.获取绑定结果（结果包含错误文案code，不会抛出异常）
        BindingResult result = dataBinder.getBindingResult();
        System.out.println(result);
    }
}