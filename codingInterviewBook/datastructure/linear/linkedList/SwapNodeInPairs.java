package datastructure.linear.linkedList;

/**
 * 24. Swap Nodes in Pairs
 */
public class SwapNodeInPairs {

    public static void main(String[] args) {
        ListNode node1_5 = new ListNode(5, null);
        ListNode node1_4 = new ListNode(4, node1_5);
        ListNode node1_3 = new ListNode(3, node1_4);
        ListNode node1_2 = new ListNode(2, node1_3);
        ListNode node1_1 = new ListNode(1, node1_2);
        ListNode v2Answer = swapPairsV2(node1_1);
        ListNode v1Answer = swapPairsV1(node1_1);
    }

    // Memory: 41.2mb
    public static ListNode swapPairsV1(ListNode head) {
        ListNode node = head;
        while (node != null && node.next != null) {
            int tmp;
            tmp = node.val;
            node.val = node.next.val;
            node.next.val = tmp;
            node = node.next.next;
        }
        return head;
    }

    // Memory: 41.5mb
    public static ListNode swapPairsV2(ListNode head) {
        if (head != null && head.next != null) {
            ListNode p = head.next;
            head.next = swapPairsV2(head.next.next);
            p.next = head;
            return p;
        }
        return head;
    }
}
