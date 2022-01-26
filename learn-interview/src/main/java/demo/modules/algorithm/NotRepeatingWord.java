package demo.modules.algorithm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 去掉字符串中连续重复的字符
 */
public class NotRepeatingWord {
    public static String transform(String input) {
        StringBuilder s = new StringBuilder();
        Matcher m = Pattern.compile("(\\w)\\1*").matcher(input);
        while (m.find()) {
            s.append(m.group().subSequence(0, 1));
        }
        return s.toString();
    }

    public static void main(String[] args) {
        System.out.println(NotRepeatingWord.transform("abbcbbb"));
    }
}