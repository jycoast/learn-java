package demo.modules.concurrency;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用ReentrantLock的demo
 * @author jiyongchao
 */
public class LockDemo {
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            lock.lock();
            System.out.println("t1 started!");
            try {
                Thread.sleep(5000);
                System.out.println("t1 completed!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            System.out.println();
        });

        Thread t2 = new Thread(() -> {
            System.out.println("t2 started!");
               while (lock.isLocked()) {

               }
                System.out.println("t2 completed!");

            System.out.println();
        });

        t2.start();
        t1.start();
    }
}
