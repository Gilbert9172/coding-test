package datastructure.linear.linkedList;

/**
 * 328. Odd Even Linked List
 */
public class OddEvenLinkedList {
    public static void main(String[] args) {
        ListNode node1_5 = new ListNode(5, null);
        ListNode node1_4 = new ListNode(4, node1_5);
        ListNode node1_3 = new ListNode(3, node1_4);
        ListNode node1_2 = new ListNode(2, node1_3);
        ListNode node1_1 = new ListNode(1, node1_2);
        ListNode node = oddEvenList(node1_1);
        System.out.println(node);
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
