package modules.overview;

/**
 * interrupt和isInterrupt方法区别示例
 */
public class InterruptedAndIsInterruptedDistinct2 {
    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {

            @Override
            public void run() {
                // 中断标志位true时会退出循环，并清除中断标志
                while (!Thread.interrupted()) {

                }
                System.out.println("thread one is isInterrupted: " + Thread.currentThread().isInterrupted());
            }
        });
        //启动线程
        threadOne.start();
        // 设置中断标志
        threadOne.interrupt();

        threadOne.join();

        System.out.println("main thread is over");
    }
}
