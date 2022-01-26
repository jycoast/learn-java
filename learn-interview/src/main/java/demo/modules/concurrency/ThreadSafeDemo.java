package demo.modules.concurrency;


import java.util.concurrent.CountDownLatch;

/**
 * 三个线程同时执行的demo
 *
 * @author jiyongchao
 */
public class ThreadSafeDemo {

    private int count = 0;

    private void add() {
        count ++;
    }

    public static void main(String[] args) throws InterruptedException {
        int size = 3;
        ThreadSafeDemo threadSafeDemo = new ThreadSafeDemo();

        CountDownLatch countDownLatch = new CountDownLatch(1);

        for (int i = 0; i < size; i++) {
            new Thread(() -> {
                try {
                    countDownLatch.await();
                    System.out.println(System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        System.out.println("wait");
        Thread.sleep(5000);
        countDownLatch.countDown();
    }
}
