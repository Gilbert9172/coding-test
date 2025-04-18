package linkedList.hard.quiz23;

import java.util.Comparator;
import java.util.PriorityQueue;

public class JavaSolutionV2 {

    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        Comparator<ListNode> comparator = Comparator.comparing(it -> it.val);
        PriorityQueue<ListNode> pq = new PriorityQueue<>(comparator);

        for (ListNode node : lists) {
            if (node != null) pq.offer(node);
        }

        ListNode result = new ListNode(Integer.MIN_VALUE);
        ListNode prev = result;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            prev.next = node;
            prev = node;

            if (node.next != null) {
                pq.offer(node.next);
            }
        }

        return result.next;
    }
}
