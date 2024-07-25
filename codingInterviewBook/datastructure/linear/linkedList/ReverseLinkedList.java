package datastructure.linear.linkedList;

/**
 * 206. Reverse Linked List
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        // create Test Case
        ListNode node1_5 = new ListNode(5, null);
        ListNode node1_4 = new ListNode(4, node1_5);
        ListNode node1_3 = new ListNode(3, node1_4);
        ListNode node1_2 = new ListNode(2, node1_3);
        ListNode node1_1 = new ListNode(1, node1_2);

        ListNode iterativeSolve = iterativeSolve(node1_1);
        System.out.println(iterativeSolve);

        ListNode recursiveSolve = recursiveSolve(node1_1, null);
        System.out.println(recursiveSolve);
    }

    public static ListNode iterativeSolve(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static ListNode recursiveSolve(ListNode node, ListNode prev) {
        if (node == null) {
            return prev;
        }
        // 현재 노드의 다음노드 미리 지정
        ListNode next = node.next;
        // 현재 노드의 다음으로 이전 노드 설정
        node.next = prev;
        return recursiveSolve(next, node);
    }
}
