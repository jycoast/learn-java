package leetcode.solution.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @see <a href="https://leetcode-cn.com/problems/min-stack/">最小栈</a>
 */
class MinStack {

    Deque<Integer> minStack;
    Deque<Integer> stack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        minStack = new LinkedList<>();
        stack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        minStack.push(Math.min(val, minStack.pop()));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.pop();
    }
}
