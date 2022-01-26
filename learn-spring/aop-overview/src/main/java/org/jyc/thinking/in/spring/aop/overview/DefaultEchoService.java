package org.jyc.thinking.in.spring.aop.overview;

/**
 * {@link EchoService} 默认实现
 */
public class DefaultEchoService implements EchoService {
    @Override
    public String echo(String message) {
        return "[ECHO]" + message;
    }
}
