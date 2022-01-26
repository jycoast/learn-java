package org.jyc.thinking.in.spring.aop.overview;

/**
 * 静态代理类
 */
public class ProxyEchoService implements EchoService {

    private EchoService echoService;

    public ProxyEchoService(EchoService echoService) {
        this.echoService = echoService;
    }

    @Override
    public String echo(String message) {
        long startTime = System.currentTimeMillis();
        String result = echoService.echo(message);
        long costTime = System.currentTimeMillis() - startTime;
        System.out.println("echo方法执行时间: " + costTime);
        return result;
    }
}
