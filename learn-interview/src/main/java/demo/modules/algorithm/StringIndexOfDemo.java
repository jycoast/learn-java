package demo.modules.algorithm;

/**
 * 实现一个类似String的indexOf(String str)的方法，用最简单实现即可
 * 查找字符串str在目标字符串source中第一次出现的位置。
 * 不可以调用任何第三方库，也不可以用String.equals，String.substring方法
 */
public class StringIndexOfDemo {

    public static int indexOf(String source, String str) {
        int i = 0, j = 0;
        while (i < source.length() && j < str.length()) {
            if (source.charAt(i) == str.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
            if (j == str.length()) {
                return i - j;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(indexOf("abcabdef", "abd"));
        System.out.println(indexOf("abcabdef", "bc"));
        System.out.println(indexOf("abcabdef", "d"));
    }
}
