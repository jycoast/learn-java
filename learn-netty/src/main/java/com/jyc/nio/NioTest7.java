package com.jyc.nio;

import java.nio.ByteBuffer;

/**
 * 只读Buffer的示例
 */
public class NioTest7 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put((byte) i);
        }
        // 数据是和原来共享的，但是不允许修改
        ByteBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();
        System.out.println(readOnlyBuffer.getChar());

        readOnlyBuffer.position(0);
        readOnlyBuffer.put((byte) 2);
    }
}
