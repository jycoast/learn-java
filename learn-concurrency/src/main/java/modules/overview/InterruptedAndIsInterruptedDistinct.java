package modules.overview;

/**
 * interrupt和isInterrupt方法区别示例
 */
public class InterruptedAndIsInterruptedDistinct {
    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {

            @Override
            public void run() {
                for (; ; ) {

                }
            }
        });
        //启动线程
        threadOne.start();
        // 设置中断标志
        threadOne.interrupt();
        // 获取中断标志
        System.out.println("isInterrupted: " + threadOne.isInterrupted()); // true
        // 获取中断标志并重置
        System.out.println("isInterrupted: " + threadOne.interrupted()); // false
        // 获取中断标志并重置
        System.out.println("isInterrupted: " + Thread.interrupted()); // false
        // 获取中断标志
        System.out.println("isInterrupted: " + threadOne.isInterrupted()); // true

        threadOne.join();

        System.out.println("main thread is over");
    }
}
