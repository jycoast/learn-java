package org.jyc.thinking.in.spring.aop.overview;

import java.lang.reflect.Method;

/**
 * （方法返回）后置拦截器
 */
public interface AfterReturnInterceptor {
    /**
     * @param returnResult 方法的返回结果
     */
    Object after(Object proxy, Method method, Object[] args, Object returnResult);
}
