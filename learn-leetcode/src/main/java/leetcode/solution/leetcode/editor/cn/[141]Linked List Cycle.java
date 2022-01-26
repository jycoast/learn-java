package leetcode.solution.leetcode.editor.cn;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
class LinkedListCycle {
    //    public boolean hasCycle(ListNode head) {
//        Set<ListNode> listNodes = new LinkedHashSet<ListNode>;
//        while (head != null) {
//            if (!listNodes.add(head.next)) {
//                return true;
//            }
//            head = head.next;
//        }
//        return false;
//    }
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
