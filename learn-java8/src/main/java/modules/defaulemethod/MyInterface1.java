package modules.defaulemethod;

/**
 * 2 * @Author: jiyongchao
 * 3 * @Date: 2020/8/25 23:17
 * 4
 */
public interface MyInterface1 {
    default void myMethod() {
        System.out.println("MyInterface1");
    }
}
