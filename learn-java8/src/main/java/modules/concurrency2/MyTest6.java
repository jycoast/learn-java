package modules.concurrency2;

/**
 * 2 * @Author: jiyongchao
 * 3 * @Date: 2020/11/9 22:40
 * 4
 */
public class MyTest6 {
    Object object = new Object();

    public void method() {
        synchronized (object) {
            System.out.println("hello world");
        }

        synchronized (object) {
            System.out.println("welcome");
        }

        synchronized (object) {
            System.out.println("person");
        }
    }
}
