package demo.modules.concurrency;

/**
 * volatile内存可见性示例
 *
 * @author ecidi
 */
public class VolatileDemo {
    private static volatile boolean flag = true;

//    private static boolean flag = true;

    public static void main(String[] args) {
        new Thread(() -> {
            while (flag) {
                // ..
            }
            System.out.println("=============");
        }).start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = false;
    }
}
