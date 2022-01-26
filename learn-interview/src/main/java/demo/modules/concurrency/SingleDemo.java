package demo.modules.concurrency;

/**
 * 单例设计模式示例，使用Volatile关键字防止指令重排序
 *
 * @author ecidi
 */
public class SingleDemo {

    private volatile SingleDemo singleDemo;

    private SingleDemo() {

    }

    public SingleDemo getInstance() {
        //
//        if (null == this.singleDemo) {
//            synchronized (SingleDemo.class) {
//                if (null == this.singleDemo) {
//                    singleDemo = new SingleDemo();
//                }
//            }
        singleDemo = new SingleDemo();
        return singleDemo;
    }
}
