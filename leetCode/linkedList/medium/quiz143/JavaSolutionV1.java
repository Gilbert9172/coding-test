package linkedList.medium.quiz143;

public class JavaSolutionV1 {

    public static void main(String[] args) {
        ListNode node1_5 = new ListNode(5, null);
        ListNode node1_4 = new ListNode(4, node1_5);
        ListNode node1_3 = new ListNode(3, node1_4);
        ListNode node1_2 = new ListNode(2, node1_3);
        ListNode head = new ListNode(1, node1_2);
        new JavaSolutionV1().reorderList(head);
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public void reorderList(ListNode head) {
        ListNode fast = head, slow = head;

        // step1. pivot 찾기
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode cur = slow.next;
        slow.next = null;

        // step2. pivot 이후의 연결리스트 뒤집기
        ListNode pre = null;
        while (cur != null) {
            ListNode t = cur.next;
            cur.next = pre;
            pre = cur;
            cur = t;
        }

        // step3. cur를 head로 원위치
        cur = head;

        //
        while (pre != null) {
            ListNode t = pre.next;
            pre.next = cur.next;
            cur.next = pre;
            cur = pre.next;
            pre = t;
        }
    }
}
