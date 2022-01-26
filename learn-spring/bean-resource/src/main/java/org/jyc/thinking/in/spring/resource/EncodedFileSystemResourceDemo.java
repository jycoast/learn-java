package org.jyc.thinking.in.spring.resource;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.StreamUtils;

import java.io.CharArrayWriter;
import java.io.File;
import java.io.Reader;

/**
 * 带有字符编码的{@link org.springframework.core.io.FileSystemResource}
 *
 * @author jiyongchao
 */
public class EncodedFileSystemResourceDemo {
    public static void main(String[] args) throws Exception {
        String currentJavaFilePath = System.getProperty("user.dir") + "/bean-resource/src/main/java/org/jyc/thinking/in/spring/resource/EncodedFileSystemResourceDemo.java";
        System.out.println(currentJavaFilePath);
        File currentJavaFile = new File(currentJavaFilePath);
        FileSystemResource fileSystemResource = new FileSystemResource(currentJavaFile);
        EncodedResource encodedResource = new EncodedResource(fileSystemResource, "UTF-8");
        // 字符输入流
        try (Reader reader = encodedResource.getReader()) {
            System.out.println(IOUtils.toString(reader));
        }
    }
}
