package org.jyc.thinking.in.spring.aop.overview;

/**
 * 类加载示例
 */
public class ClassLoaderDemo {
    public static void main(String[] args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader);

        ClassLoader parent = classLoader;
        while (true) {
            parent = parent.getParent();
            if (parent == null) {
                break;
            }
            System.out.println(parent);
        }
    }
}
