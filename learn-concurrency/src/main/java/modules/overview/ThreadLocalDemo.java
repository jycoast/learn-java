package modules.overview;

public class ThreadLocalDemo {

    // 1.print函数
    static void print(String str) {
        // 打印当前线程本地内存地中localVariable变量的值
        System.out.println(str + ":" + localVariable.get());
        // 清除当前线程本地内存中的localVariable变量
        localVariable.remove();
    }

    // 2.创建ThreadLocal变量
    static ThreadLocal<String> localVariable = new ThreadLocal<>();

    public static void main(String[] args) {

        // 3.创建线程one
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                // 设置线程One中本地变量localVariable的值
                localVariable.set("threadOne local variable");
                // 调用打印函数
                print("threadOne");
                // 打印本地变量值
                System.out.println("threadOne remove after" + ":" + localVariable.get());
            }
        });
        // 4.创建线程two
        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                // 设置线程two中本地变量localVariable的值
                localVariable.set("threadTwo local variable");
                // 调用打印函数
                print("threadTwo");
                // 打印本地变量值
                System.out.println("threadTwo remove after" + ":" + localVariable.get());
            }
        });

        threadOne.start();
        threadTwo.start();
    }
}
