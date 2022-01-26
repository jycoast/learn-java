package modules.concurrency2;

/**
 * 2 * @Author: jiyongchao
 * 3 * @Date: 2020/11/16 23:24
 * 4
 */
public class MyTest7 {
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void method1() {
        synchronized (lock1) {
            synchronized (lock2) {
                System.out.println("myMethod1 invoked");
            }
        }
    }

    public void method2() {
        synchronized (lock2) {
            synchronized (lock1) {
                System.out.println("myMethod2 invoked");
            }
        }
    }

    public static void main(String[] args) {
        MyTest7 myTest7 = new MyTest7();
        Runnable runnable1 = () -> {
            while (true) {
                myTest7.method1();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread1 = new Thread(runnable1, "myThread1");

        Runnable runnable2 = () -> {
            while (true) {
                myTest7.method2();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread2 = new Thread(runnable2, "myThread2");
        thread1.start();
        thread2.start();
    }
}
