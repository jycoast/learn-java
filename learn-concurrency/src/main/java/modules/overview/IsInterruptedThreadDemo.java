package modules.overview;

/**
 * 使用isInterrupted()判断线程是否中断示例
 */
public class IsInterruptedThreadDemo {
    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread() + "hello");
                }
            }
        });

        // 启动子线程
        thread.start();

        //主线程休眠1s，以便中断前让子线程输出
        Thread.sleep(1000);

        // 中断子线程
        System.out.println("main thread interrupt thread");
        thread.interrupt();

        // 等待子线程执行完毕
        thread.join();
        System.out.println("main is over");
    }
}
