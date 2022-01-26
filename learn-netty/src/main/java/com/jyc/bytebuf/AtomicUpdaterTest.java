package com.jyc.bytebuf;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicUpdaterTest {
    public static void main(String[] args) throws Exception {
        Person person = new Person();
//        for (int i = 0; i < 10; i++) {
//            Thread thread = new Thread(() -> {
//                try {
//                    Thread.sleep(200);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(person.age++);
//            });
//            thread.start();
//        }
        AtomicIntegerFieldUpdater<Person> atomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(Person.class, "age");
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(atomicIntegerFieldUpdater.getAndIncrement(person));
            });
            thread.start();
        }
    }
}

class Person {
    // 注意必须是volatile类型的
    volatile int age = 1;
}
