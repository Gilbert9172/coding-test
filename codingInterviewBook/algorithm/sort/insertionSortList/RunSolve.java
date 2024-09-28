package algorithm.sort.insertionSortList;

public class RunSolve {
    public static void main(String[] args) {
        // -1 5 3 4 0
        ListNode n4 = new ListNode(0, null);
        ListNode n3 = new ListNode(4, n4);
        ListNode n2 = new ListNode(3, n3);
        ListNode n1 = new ListNode(5, n2);
        ListNode head = new ListNode(-1, n1);

        // 5 2 1 3
//        ListNode n3 = new ListNode(3, null);
//        ListNode n2 = new ListNode(1, n3);
//        ListNode n1 = new ListNode(2, n2);
//        ListNode head = new ListNode(5, n1);
        V1 solution = new V1();
        solution.insertionSortList(head);
    }
}
