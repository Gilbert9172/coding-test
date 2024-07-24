package datastructure.linear.linkedList;

import java.util.Deque;
import java.util.LinkedList;

public class PalindromeLinkedList {
    public static void main(String[] args) {

    }

    public static boolean solve(ListNode head) {
        Deque<Integer> deque = new LinkedList<>();
        ListNode node = head;
        while (node != null) {
            deque.add(node.val);
            node = node.next;
        }

        while (!deque.isEmpty() && deque.size() > 1) {
            if (deque.pollFirst() != deque.pollLast()) {
                return false;
            }
        }
        return true;
    }
}
