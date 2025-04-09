package linkedList.medium.quiz12;

import java.util.ArrayList;
import java.util.List;

public class JavaSolutionV1 {

    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        List<ListNode> nodes = new ArrayList<>();

        ListNode cur = head;
        while (cur != null) {
            nodes.add(cur);
            cur = cur.next;
        }

        ListNode result = new ListNode(-1);
        ListNode prev = result;
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.size() - i != n) {
                ListNode node = new ListNode(nodes.get(i).val);
                prev.next = node;
                prev = node;
            }
        }

        return result.next;
    }
}
