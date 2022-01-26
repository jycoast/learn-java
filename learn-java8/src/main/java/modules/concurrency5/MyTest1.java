package modules.concurrency5;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class MyTest1 {
    public static void main(String[] args) {
        BoundedContainer boundedContainer = new BoundedContainer();
        IntStream.range(0, 10).forEach(i -> new Thread(() -> {
            try {
                boundedContainer.take();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }).start());
        IntStream.range(0, 10).forEach(i -> new Thread(() -> {
            try {
                boundedContainer.put("hello");
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }).start());
    }
}


class BoundedContainer {

    private String[] elements = new String[10];

    private Lock lock = new ReentrantLock();

    private Condition notEmptyCondition = lock.newCondition();

    private Condition notFullCondition = lock.newCondition();

    // 数组中已有元素的数量
    private int elementCount;

    // 放置元素索引
    private int putIndex;

    // 提取元素索引
    private int takeIndex;

    /**
     * 放置元素的方法
     *
     * @param element 需要放置的目标元素
     * @throws Exception
     */
    public void put(String element) throws Exception {
        this.lock.lock();
        try {
            while (this.elementCount == this.elements.length) {
                notFullCondition.await();
            }
            elements[putIndex] = element;

            if (++putIndex == this.elements.length) {
                putIndex = 0;
            }
            ++elementCount;
            System.out.println("put method: " + Arrays.toString(elements));
            notEmptyCondition.signal();
        } finally {
            this.lock.unlock();
        }
    }

    /**
     * 获取元素的方法
     *
     * @return 获取元素
     * @throws Exception
     */
    public String take() throws Exception {
        this.lock.lock();
        try {
            while (this.elementCount == 0) {
                notEmptyCondition.await();
            }
            String element = elements[takeIndex];
            elements[takeIndex] = null;
            if (++takeIndex == this.elements.length) {
                takeIndex = 0;
            }
            --elementCount;
            System.out.println("take method: " + Arrays.asList(elements));
            notFullCondition.signal();
            return element;
        } finally {
            this.lock.unlock();
        }
    }
}