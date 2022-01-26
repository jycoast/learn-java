package modules.Stream2;

/**
 * 2 * @Author: jiyongchao
 * 3 * @Date: 2020/10/3 22:11
 * 4
 */
public class AutoCloseableTest implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("close invoked!");
    }

    public void doSomething() {
        System.out.println("doSomething invoked!");
    }

    public static void main(String[] args) throws Exception {
        try (AutoCloseableTest autoCloseableTest = new AutoCloseableTest()) {
            autoCloseableTest.doSomething();
        }
    }
}
