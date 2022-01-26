package modules.overview;

public class InterruptedDemo {
    public void run() {
        while (Thread.currentThread().isInterrupted()) {
            // do more work;
        }
    }
}
