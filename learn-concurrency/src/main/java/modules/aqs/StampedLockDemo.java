package modules.aqs;

import java.util.concurrent.locks.StampedLock;

public class StampedLockDemo {
    private final StampedLock stampedLock = new StampedLock();

    private double x;

    private double y;

    public void move(double deltaX,double deltaY) {
        // 获取写锁
        long stamp = stampedLock.writeLock();
        try {
            x += deltaX;
            y += deltaY;
        }finally {
            stampedLock.unlock(stamp);
        }
    }

    public double distanceFromOrigin() {
        // 获取一个乐观读锁
        long stamp = stampedLock.tryOptimisticRead();
        // 注意下面两行代码不是原子操作
        // 假设x,y = (100,200)
        double currentX = x;
        // 此处已读取到y，但x，y可能被线程修改为（300，400）
        double currentY = y;
        // 此处已读取到y，如果没有写入，读取是正确的（100，200）
        if (!stampedLock.validate(stamp)) {  // 检查乐观读锁后是否有其它写锁发生
            // 获取一个悲观读锁
            stamp = stampedLock.readLock();
            try {
                currentX = x;
                currentY = y;
            }finally {
                // 释放悲观读锁
                stampedLock.unlockRead(stamp);
            }
        }
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }
}
