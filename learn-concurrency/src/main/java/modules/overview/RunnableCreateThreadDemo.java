package modules.overview;

public class RunnableCreateThreadDemo implements Runnable {
    @Override
    public void run() {
        System.out.println("RunnableDemo run() invoke!");
    }

    public static void main(String[] args) {
        new Thread(new RunnableCreateThreadDemo()).run();
    }
}
