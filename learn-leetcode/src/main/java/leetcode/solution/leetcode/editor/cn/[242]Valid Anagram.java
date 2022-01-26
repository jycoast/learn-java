package leetcode.solution.leetcode.editor.cn;

import java.util.HashMap;

/**
 * @see <a href="https://leetcode-cn.com/problems/valid-anagram/">有效字母异位词</a>
 */
class ValidAnagram {
    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        System.out.println(validAnagram.isAnagram("anagram", "nagaram"));
    }

//    public boolean isAnagram(String s, String t) {
//        char[] sChars = s.toCharArray();
//        char[] tChars = t.toCharArray();
//        // 注意这里不能简写为 Arrays.sort(s.toCharArray())，因为Arrays.sort采用的就地排序。
//        Arrays.sort(sChars);
//        Arrays.sort(tChars);
//        return Arrays.equals(sChars, tChars);
//    }

    /**
     * 哈希表实现
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> hashTable = new HashMap<>();
        for (char c : s.toCharArray()) {
            hashTable.put(c, hashTable.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            hashTable.put(c, hashTable.getOrDefault(c, 0) - 1);
            if (hashTable.get(c) < 0) {
                return false;
            }
        }
        return true;
    }
}
