package com.jyc.nio;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;

/**
 * 编解码示例
 */
public class NioTest13 {
    public static void main(String[] args) throws Exception {
        String inputFile = "NioTest13_In.txt";
        String outputFile = "NioTest13_Out.txt";
        RandomAccessFile inputRandomAccessFile = new RandomAccessFile(inputFile, "r");
        RandomAccessFile outputRandomAccessFile = new RandomAccessFile(outputFile, "rw");
        long inputLength = new File(inputFile).length();
        FileChannel inputFileChannel = inputRandomAccessFile.getChannel();
        FileChannel outputFileChannel = outputRandomAccessFile.getChannel();
        MappedByteBuffer inputData = inputFileChannel.map(FileChannel.MapMode.READ_ONLY, 0, inputLength);

        System.out.println("==================");
        // 当前操作系统支持的所有的字符集
        Charset.availableCharsets().forEach((k,v) -> {
            System.out.println(k + "," + v);
        });

        Charset charset = StandardCharsets.ISO_8859_1;
        // 解码
        CharsetDecoder decoder = charset.newDecoder();
        // 编码
        CharsetEncoder encoder = charset.newEncoder();
        CharBuffer charBuffer = decoder.decode(inputData);
        System.out.println(charBuffer.get(13));
        ByteBuffer outputData = encoder.encode(charBuffer);
        outputFileChannel.write(outputData);
        inputRandomAccessFile.close();
        outputRandomAccessFile.close();
    }
}