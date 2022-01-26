package com.jyc.nio;

import java.nio.IntBuffer;
import java.security.SecureRandom;

public class NioTest1 {
    public static void main(String[] args) {
        // 创建一个只能放置10个整数的缓冲区
        IntBuffer buffer = IntBuffer.allocate(10);

        System.out.println("capacity: " + buffer.capacity());

        for (int i = 0; i < 5; i++) {
            int randomNumber = new SecureRandom().nextInt(20);
            buffer.put(randomNumber);
        }
        // 10
        System.out.println("before flip limit: " + buffer.limit());
        buffer.flip();
        // 5
        System.out.println("after flip limit: " + buffer.limit());
        System.out.println("enter while loop ");
        while (buffer.hasRemaining()) {
            // 0
            System.out.println("position: " + buffer.position());
            // 5
            System.out.println("limit: " + buffer.limit());
            // 10
            System.out.println("capacity: " + buffer.capacity());
            System.out.println(buffer.get());
        }
    }
}
