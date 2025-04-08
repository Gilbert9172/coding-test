package linkedList.medium.quiz142;

public class JavaSolutionV1 {

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

            if (slow == fast) {
                ListNode pointer1 = head;
                ListNode pointer2 = fast;

                while (pointer1 != pointer2) {
                    pointer1 = pointer1.next;
                    pointer2 = pointer2.next;
                }
                return pointer1;
            }
        }
        
        return null;
    }
}
