package linkedList.medium.quiz142;

import java.util.HashSet;

public class JavaSolutionV3 {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> visited = new HashSet<>();
        ListNode cur = head;

        while (cur != null) {
            if (visited.contains(cur)) return cur;

            visited.add(cur);
            cur = cur.next;
        }

        return null;
    }
}
