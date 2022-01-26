package org.jyc.thinking.in.spring.aop.overview;

/**
 * 静态代理示例
 */
public class StaticProxyDemo {
    public static void main(String[] args) {
        ProxyEchoService proxyEchoService = new ProxyEchoService(new DefaultEchoService());
        proxyEchoService.echo("hello world");
    }
}
