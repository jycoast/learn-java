package modules.synchro;

import java.util.concurrent.Semaphore;

public class SemaphoreSingleThreadDemo {
    // 控制线程的数目为1，也就是单线程
    private static Semaphore semaphore = new Semaphore(3);

    public static void main(String[] args) {
        try {
            // 从信号量中获取一个允许机会
            semaphore.acquire();
            System.out.println(Thread.currentThread() + "start at" + System.currentTimeMillis());
            Thread.sleep(1000);
            System.out.println(Thread.currentThread() + "stop at" + System.currentTimeMillis());
            // 释放允许，将占有的信号量归还
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
