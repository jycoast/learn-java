package modules.concurrency2;

/**
 * 2 * @Author: jiyongchao
 * 3 * @Date: 2020/10/28 23:26
 * 4
 */
public class MyTest2 {
    private Object object = new Object();

    public void method() {
        // 获取到object对象的锁
        synchronized (object) {
            System.out.println("hello world");
            throw new RuntimeException();
        }
    }

//    public void method2() {
//        synchronized (object) {
//            System.out.println("welcome");
//        }
//    }
}
