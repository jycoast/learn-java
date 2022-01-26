package modules.overview;

public class VolatileAtomicDemo {

    private static int num = 0;

    private static volatile boolean ready = false;

    public static class ReadThread extends Thread{
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                if (ready) {
                    System.out.println(num + num);
                }
            }
            System.out.println("read thread...");
        }
    }

    public static class WriteThread extends Thread{
        public void run() {
            // 这里可能会发生指令重排序，有可能先执行ready = true
            // 此时读线程可能已经获取到ready的值，那么输出的结果就是0，而不是4
            num = 2;
            ready = true;
            System.out.println("writeThread set over...");
        }
    }

    public static void main(String[] args) throws InterruptedException{
        ReadThread readThread = new ReadThread();
        readThread.start();

        WriteThread writeThread = new WriteThread();
        writeThread.start();

        Thread.sleep(10);
        readThread.interrupt();
        System.out.println("main exit");
    }
}
