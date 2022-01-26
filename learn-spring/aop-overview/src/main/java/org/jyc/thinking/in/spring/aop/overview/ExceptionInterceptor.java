package org.jyc.thinking.in.spring.aop.overview;

import java.lang.reflect.Method;

/**
 * 异常拦截器
 */
public interface ExceptionInterceptor {
    /**
     * @param throwable 异常信息
     */
    void intercpt(Object proxy, Method method, Object[] args, Throwable throwable);
}
