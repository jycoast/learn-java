package modules.overview;

public class ThreadCreateDemo extends Thread {

    @Override
    public void run() {
        System.out.println("ThreadDemo run() invoke!");
    }

    public static void main(String[] args) {
        ThreadCreateDemo threadDemo = new ThreadCreateDemo();
        threadDemo.start();
    }
}
