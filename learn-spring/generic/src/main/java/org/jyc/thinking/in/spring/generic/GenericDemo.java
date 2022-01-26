package org.jyc.thinking.in.spring.generic;


import java.util.ArrayList;
import java.util.Collection;

/**
 * 泛型示例
 *
 * @author jiyongchao
 */
public class GenericDemo {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        // 编译时错误
//        list.add(1);

        // 泛型擦写
        Collection temp = list;
        // 编译通过
        temp.add(1);
        System.out.println(list);
    }
}
