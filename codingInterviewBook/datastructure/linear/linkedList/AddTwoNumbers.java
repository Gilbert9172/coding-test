package datastructure.linear.linkedList;

import java.math.BigInteger;

/**
 * 2. Add Two Numbers
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode node2_3 = new ListNode(4, null);
        ListNode node2_2 = new ListNode(6, node2_3);
        ListNode l2 = new ListNode(5, node2_2);

        ListNode node1_3 = new ListNode(3, null);
        ListNode node1_2 = new ListNode(4, node1_3);
        ListNode l1 = new ListNode(2, node1_2);


        ListNode l1Reversed = reverseNode(l1, null);
        ListNode l2Reversed = reverseNode(l2, null);

        BigInteger result = toBigInt(l1Reversed).add(toBigInt(l2Reversed));
        ListNode reverseLinkedList = toReverseLinkedList(result);
        System.out.println(reverseLinkedList);
    }
    public static ListNode reverseNode(ListNode node, ListNode prev) {
        if (node == null) {
            return prev;
        }
        ListNode next = node.next;
        node.next = prev;
        return reverseNode(next, node);
    }

    public static BigInteger toBigInt(ListNode node) {
        StringBuilder val = new StringBuilder();
        while (node != null) {
            val.append(node.val);
            node = node.next;
        }
        return new BigInteger(val.toString());
    }

    public static ListNode toReverseLinkedList(BigInteger val) {
        ListNode prev = null;
        ListNode node = null;
        for (char c : String.valueOf(val).toCharArray()) {
            node = new ListNode(Character.getNumericValue(c));
            node.next = prev;
            prev = node;
        }
        return node;
    }
}
