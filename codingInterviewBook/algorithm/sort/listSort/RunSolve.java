package algorithm.sort.listSort;

public class RunSolve {
    public static void main(String[] args) {
        ListNode n4 = new ListNode(0, null);
        ListNode n3 = new ListNode(4, n4);
        ListNode n2 = new ListNode(3, n3);
        ListNode n1 = new ListNode(5, n2);
        ListNode n0 = new ListNode(-1, n1);

        V1 solution = new V1();
        solution.sortList(n0);
    }
}
