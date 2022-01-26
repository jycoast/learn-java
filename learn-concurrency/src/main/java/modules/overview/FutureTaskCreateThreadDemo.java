package modules.overview;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class FutureTaskCreateThreadDemo implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "hello world";
    }

    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<>(new FutureTaskCreateThreadDemo());
        new Thread(futureTask).start();
        try {
            String result = futureTask.get();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
