package org.jyc.thinking.in.spring.aop.overview;

/**
 * Echo服务
 */
public interface EchoService {

    String echo(String message) throws NullPointerException;
}
