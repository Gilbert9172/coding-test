package linkedList.medium.quiz142;

public class JavaSolutionV2 {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }

        if (fast == null || fast.next == null) return null;

        ListNode start = head;
        while (start != slow) {
            start = start.next;
            slow = slow.next;
        }

        return start;
    }
}
