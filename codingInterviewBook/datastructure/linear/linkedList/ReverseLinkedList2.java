package datastructure.linear.linkedList;

/**
 * 92. Reverse Linked List II
 */
public class ReverseLinkedList2 {
    public static void main(String[] args) {
        ListNode node1_6 = new ListNode(6, null);
        ListNode node1_5 = new ListNode(5, node1_6);
        ListNode node1_4 = new ListNode(4, node1_5);
        ListNode node1_3 = new ListNode(3, node1_4);
        ListNode node1_2 = new ListNode(2, node1_3);
        ListNode node1_1 = new ListNode(1, node1_2);
        ListNode node = reverseBetween(node1_1, 2, 5);
        System.out.println(node);
    }
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return null;
        }
        // 가상의 노드 생성하기
        ListNode root = new ListNode(0);
        root.next = head;

        // 노드 변경 시작점으롸 이동하기
        ListNode start = root;
        for (int i = 0; i < left - 1; i++) {
            start = start.next;
        }
        // 가장 가까운 변경 마지막 노드 설정하기
        ListNode end = start.next;

        // 해당 범위의 노드 순서 변경하기
        for (int i = 0; i < right - left; i++) {
            ListNode tmp = start.next;
            start.next = end.next;
            end.next = end.next.next;
            start.next.next = tmp;
        }
        return root.next;
    }
}
