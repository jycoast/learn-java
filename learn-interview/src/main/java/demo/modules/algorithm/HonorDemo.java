package demo.modules.algorithm;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 荣耀面试题
 */
public class HonorDemo {
    public static void main(String[] args) {
        HashMap<String, Integer> SourceMap = new HashMap<>();
        HashMap<String, Integer> targetMap = new HashMap<>();
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String[] split = in.next().split(":");
            SourceMap.put(split[0], Integer.valueOf(split[1]));
        }
        System.out.println(SourceMap);
    }
}