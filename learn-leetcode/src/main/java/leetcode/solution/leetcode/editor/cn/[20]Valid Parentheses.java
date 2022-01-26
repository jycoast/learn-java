package leetcode.solution.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

class ValidParentheses {
    //    public boolean isValid(String s) {
//        Map<Character, Character> characterMap = new HashMap<>();
//        characterMap.put('{', '}');
//        characterMap.put('[', ']');
//        characterMap.put('(', ')');
//        Deque<Character> stack = new LinkedList<>();
//        for (int i = 0; i < s.length(); i++) {
//            char bracket = s.charAt(i);
//            // 栈中有左括号
//            if (characterMap.containsKey(bracket)) {
//                // 如果栈中元素为空或者与Map中括号不匹配
//                if (stack.isEmpty() || stack.peek() != characterMap.get(bracket)) {
//                    return false;
//                }
//                stack.pop();
//            } else {
//                stack.push(bracket);
//            }
//        }
//
//        return false;
//    }
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '(') {
                stack.push(')');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
