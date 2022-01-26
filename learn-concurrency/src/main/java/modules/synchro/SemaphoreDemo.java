package modules.synchro;

import java.util.UUID;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {

    /**
     * 控制某资源同时被访问的个数的类 控制同一时间最后只能有50个访问
     */
    private static Semaphore semaphore = new Semaphore(50);
    /**
     * 超时时间
     */
    private static int timeout = 500;

    public static void main(String[] args) {
        int i = 0;
        while (i < 500) {
            i++;
            new ConnectionTread().start();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class ConnectionTread extends Thread {
        @Override
        public void run() {
            try {
                Object connection = getConnection();
                System.out.println("获取一个连接" + connection);
                Thread.sleep(300);
                releaseConnection(connection);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void releaseConnection(Object connection) {
            semaphore.release();
            System.out.println("释放一个连接" + connection);
        }

        private Object getConnection() {
            try {
                boolean getAcquire = semaphore.tryAcquire(timeout, TimeUnit.MILLISECONDS);
                if (getAcquire) {
                    return UUID.randomUUID().toString();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            throw new IllegalArgumentException("timeout");
        }
    }
}
