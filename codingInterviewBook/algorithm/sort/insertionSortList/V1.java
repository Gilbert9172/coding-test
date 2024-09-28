package algorithm.sort.insertionSortList;

public class V1 {
    public ListNode insertionSortList(ListNode head) {
        ListNode root = new ListNode();
        ListNode sorted = root;

        while (head != null) {
            while (sorted.next != null && sorted.next.val < head.val) sorted = sorted.next;
            ListNode sortedNext = sorted.next;
            ListNode headNext = head.next;
            sorted.next = head;
            head.next = sortedNext;
            head = headNext;
            if (head != null && sorted.val > head.val) sorted = root;
        }

        return root.next;
    }
}
