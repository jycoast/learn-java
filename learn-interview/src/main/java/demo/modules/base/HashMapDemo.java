package demo.modules.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * {@link HashMap} 示例
 * <p>
 * HashMap的key必须是不可变的对象
 */
public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<List<String>, Object> changeMap = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("hello");
        Object objectValue = new Object();
        changeMap.put(list, objectValue);
        System.out.println(changeMap.get(list));
        //hashcode发生了改变
        list.add("hello world");
        System.out.println(changeMap.get(list));
    }
}
