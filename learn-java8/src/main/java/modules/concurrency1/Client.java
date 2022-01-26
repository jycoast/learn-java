package modules.concurrency1;

/**
 * 2 * @Author: jiyongchao
 * 3 * @Date: 2020/10/26 23:31
 * 4
 */
public class Client {
    public static void main(String[] args) {
        MyObject myObject = new MyObject();
        Thread increaseThread = new IncreaseThread(myObject);
        Thread increaseThread2 = new IncreaseThread(myObject);
        Thread decreaseThread = new DecreaseThread(myObject);
        Thread decreaseThread2 = new DecreaseThread(myObject);
        increaseThread.start();
        increaseThread2.start();
        decreaseThread.start();
        decreaseThread2.start();
    }
}
