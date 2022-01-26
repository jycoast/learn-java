package demo.modules.template;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * map遍历的方式
 */
public class MapIteratorTemplate {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "jj");
        map.put("2", "yy");
        map.put("3", "cc");
    }

    private void Traverse1(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key= " + entry.getKey() + ", value= " + entry.getValue());
        }
    }

    private void Traverse2(Map<String, String> map) {
        // 只需要key
        for (String key : map.keySet()) {
            System.out.println("key= " + key);
        }
        // 只需要value
        for (String value : map.values()) {
            System.out.println("value= " + value);
        }
    }

    private void Traverse3(Map<String, String> map) {
        Iterator<Map.Entry<String,String>> entires = map.entrySet().iterator();
        while (entires.hasNext()) {
            Map.Entry<String,String> entry = entires.next();
            System.out.println("key= " + entry.getKey() + ", value= " + entry.getValue());
        }
    }

//    private void Traverse4(Map<String, String> map) {
//
//    }
}
