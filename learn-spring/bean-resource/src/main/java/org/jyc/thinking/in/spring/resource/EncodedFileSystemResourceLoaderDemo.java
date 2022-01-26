package org.jyc.thinking.in.spring.resource;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

import java.io.File;
import java.io.Reader;

/**
 * 带有字符编码的{@link org.springframework.core.io.FileSystemResourceLoader}
 *
 * @author jiyongchao
 */
public class EncodedFileSystemResourceLoaderDemo {
    public static void main(String[] args) throws Exception {
        String currentJavaFilePath = System.getProperty("user.dir") + "/bean-resource/src/main/java/org/jyc/thinking/in/spring/resource/EncodedFileSystemResourceLoaderDemo.java";
        FileSystemResourceLoader resourceLoader = new FileSystemResourceLoader();
        Resource fileSystemResource = resourceLoader.getResource(currentJavaFilePath);
        EncodedResource encodedResource = new EncodedResource(fileSystemResource, "UTF-8");
        // 字符输入流
        try (Reader reader = encodedResource.getReader()) {
            System.out.println(IOUtils.toString(reader));
        }
    }
}
