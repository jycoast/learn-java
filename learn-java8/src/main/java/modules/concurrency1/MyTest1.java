package modules.concurrency1;

/**
 * 2 * @Author: jiyongchao
 * 3 * @Date: 2020/10/18 23:04
 * 4
 */
public class MyTest1 {
    public static void main(String[] args) throws Exception{
        Object object = new Object();
        synchronized (object) {
            object.wait();
        }
    }
}
