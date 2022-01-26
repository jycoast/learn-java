package org.jyc.thinking.in.spring.event;

import java.util.EventListener;
import java.util.EventObject;
import java.util.Observable;
import java.util.Observer;

/**
 * {@link java.util.Observer}示例
 *
 * @author jiyuongchao
 */
public class ObserverDemo {
    public static void main(String[] args) {
        Observable observable = new EventObservable();
        // 添加观察者（监听者）
        observable.addObserver(new EventObserver());
        observable.notifyObservers("hello world");
    }

    static class EventObservable extends Observable {
        @Override
        public synchronized void setChanged() {
            super.setChanged();
        }

        @Override
        public void notifyObservers(Object arg) {
            setChanged();
            super.notifyObservers(new EventObject(arg));
            clearChanged();
        }
    }

    static class EventObserver implements Observer, EventListener {
        @Override
        public void update(Observable o, Object event) {
            EventObject eventObject = (EventObject) event;
            System.out.println("收到事件" + eventObject);
        }
    }
}
