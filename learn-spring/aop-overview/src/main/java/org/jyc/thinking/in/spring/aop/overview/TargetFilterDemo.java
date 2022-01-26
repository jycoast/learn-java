package org.jyc.thinking.in.spring.aop.overview;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

/**
 * AOP目标过滤示例
 */
public class TargetFilterDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        String targetClassName = "org.jyc.thinking.in.spring.aop.overview.EchoService";
        // 获取当前线程ClassLoader
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        // 获取目标类
        Class<?> targetClass = classLoader.loadClass(targetClassName);
        // 过滤名称
        Method method = ReflectionUtils.findMethod(targetClass, "echo", String.class);
        System.out.println(method);

        // 查找方法throws类型为 NullPointerException
        ReflectionUtils.doWithMethods(targetClass, method1 -> {
            System.out.println("仅抛出NullPointerException的方法为：" + method1);
        }, method2 -> {
            Class<?>[] parameterTypes = method2.getParameterTypes();
            Class<?>[] exceptionTypes = method2.getExceptionTypes();
            // 异常列表长度为1并且异常类型为NullPointerException，参数列表为1并且，参数类型为String的方法
            return exceptionTypes.length == 1 && NullPointerException.class.equals(exceptionTypes[0])
                    && parameterTypes.length == 1 && String.class.equals(parameterTypes[0]);
        });
    }
}
