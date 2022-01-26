package leetcode.solution.leetcode.editor.cn;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 *
 * @see <a href="https://leetcode-cn.com/problems/reverse-linked-list">反转链表</a>
 */
class ReverseLinkedList {
    /**
     * 双指针方式
     *
     * @param head
     * @return
     */
//    public ListNode reverseList(ListNode head) {
//        ListNode prev = null;
//        ListNode curr = head;
//        while (curr != null) {
//            ListNode next = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = next;
//        }
//        return prev;
//    }
//    public ListNode reverseList(ListNode head) {
//        ListNode curr = head;
//        while (head.next != null) {
////            head.next = curr`
//        }
//    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
