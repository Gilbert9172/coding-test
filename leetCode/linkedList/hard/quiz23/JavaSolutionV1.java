package linkedList.hard.quiz23;

import java.util.PriorityQueue;

public class JavaSolutionV1 {

    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (ListNode list : lists) {
            ListNode cur = list;
            while (cur != null) {
                pq.offer(cur.val);
                cur = cur.next;
            }
        }

        ListNode result = new ListNode(Integer.MIN_VALUE);
        ListNode prev = result;
        while (!pq.isEmpty()) {
            ListNode node = new ListNode(pq.poll());
            prev.next = node;
            prev = node;
        }

        return result.next;
    }
}
