package modules.concurrency1;

/**
 * 2 * @Author: jiyongchao
 * 3 * @Date: 2020/10/26 23:25
 * 4
 */
public class IncreaseThread extends Thread {
    private MyObject myObject;

    public IncreaseThread(MyObject myObject) {
        this.myObject = myObject;
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            try {
                Thread.sleep((long) (Math.random() * 10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myObject.increase();
        }
    }
}
