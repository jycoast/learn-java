package org.jyc.thinking.in.spring.resource;

import org.jyc.thinking.in.spring.resource.util.ResourceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import javax.annotation.PostConstruct;
import java.util.stream.Stream;

/**
 * 注入{@link org.springframework.core.io.ResourceLoader}对象示例
 *
 * @author jiyongchao
 */
public class InjectResourceLoaderDemo implements ResourceLoaderAware {

    private ResourceLoader awareResourceLoader;

    @Autowired
    ResourceLoader autowiredResourceLoader;

    @Autowired
    private AbstractApplicationContext applicationContext;

    @PostConstruct
    public void init() {
        System.out.println("awareResourceLoader == autowiredResourceLoader: " + (autowiredResourceLoader == awareResourceLoader));
        System.out.println("autowiredResourceLoader == applicationContext: " + (awareResourceLoader == applicationContext));
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(InjectResourceLoaderDemo.class);
        applicationContext.refresh();
        // 关闭应用上下文
        applicationContext.close();
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.awareResourceLoader = resourceLoader;
    }
}
