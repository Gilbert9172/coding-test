package algorithm.sort.listSort;

public class V1 {
    public ListNode sortList(ListNode head) {
        // 예외 처리
        if (head == null || head.next == null) return head;

        // Runner 기법을 사용해서 LinkedList 분할
        ListNode half = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            half = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // 중간 지점의 연결 끊어주기
        half.next = null;

        // 분할(Divide) 재귀호출
        ListNode chunk1 = sortList(head);
        ListNode chunk2 = sortList(slow);

        // 정복(Conquer) 결과를 반환
        return mergeChunks(chunk1, chunk2);
    }

    private ListNode mergeChunks(ListNode chunk1, ListNode chunk2) {
        if (chunk1 == null) return chunk2;
        if (chunk2 == null) return chunk1;

        if (chunk1.val > chunk2.val) {
            ListNode temp = chunk2;
            chunk2 = chunk1;
            chunk1 = temp;
        }
        chunk1.next = mergeChunks(chunk1.next, chunk2);
        return chunk1;
    }
}
