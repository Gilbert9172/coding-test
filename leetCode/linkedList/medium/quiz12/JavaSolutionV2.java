package linkedList.medium.quiz12;

public class JavaSolutionV2 {
    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode result = new ListNode(-1);
        result.next = head;

        ListNode slow = result;
        ListNode fast = result;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return result.next;
    }
}
