package org.jyc.thinking.in.spring.lifecycle;

import org.springframework.context.Lifecycle;

/**
 * 自定义{@link org.springframework.context.Lifecycle} 实现
 *
 * @author jiyongchao
 */
public class MyLifecycle implements Lifecycle {

    private boolean running = false;

    @Override
    public void start() {
        running = true;
        System.out.println("org.jyc.thinking.in.spring.lifecycle.MyLifecycle 启动...");
    }

    @Override
    public void stop() {
        running = false;
        System.out.println("org.jyc.thinking.in.spring.lifecycle.MyLifecycle 停止...");
    }

    @Override
    public boolean isRunning() {
        return running;
    }
}
