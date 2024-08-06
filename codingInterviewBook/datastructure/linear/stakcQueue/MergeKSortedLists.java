package datastructure.linear.stakcQueue;

import datastructure.linear.linkedList.ListNode;

import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.val == o2.val) {
                return 0;
            } else if (o1.val > o2.val) {
                return 1;
            } else {
                return -1;
            }
        });

        ListNode root = new ListNode(0);
        ListNode tail = root;

        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }
        while (!pq.isEmpty()) {
            ListNode poll = pq.poll();
            tail.next = poll;
            tail = tail.next;
            if (tail.next != null) {
                pq.add(poll.next);
            }
        }
        return root.next;
    }
}