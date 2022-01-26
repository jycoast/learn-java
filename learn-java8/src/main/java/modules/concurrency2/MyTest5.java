package modules.concurrency2;

/**
 * 2 * @Author: jiyongchao
 * 3 * @Date: 2020/11/4 23:57
 * 4
 */
public class MyTest5 {
    private Object object = new Object();

    public void method() {
        synchronized (object) {
            System.out.println("hello world");
        }
    }
}
