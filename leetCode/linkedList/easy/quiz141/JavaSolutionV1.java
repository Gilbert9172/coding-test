package linkedList.easy.quiz141;

/**
 * [141. Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)
 */
public class JavaSolutionV1 {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode turtle = head;
        ListNode rabbit = head;

        while (rabbit != null && rabbit.next != null) {
            turtle = turtle.next;
            rabbit = rabbit.next.next;
            if (turtle == rabbit) return true;
        }

        return false;
    }
}
