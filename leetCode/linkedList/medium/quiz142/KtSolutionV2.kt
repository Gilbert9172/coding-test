package linkedList.medium.quiz142

class KtSolutionV2 {

    data class ListNode(val `val`: Int) {
        var next: ListNode? = null
    }

    fun detectCycle(head: ListNode?): ListNode? {
        var slow = head
        var fast = head

        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
            if (slow == fast) break
        }

        if (fast?.next == null) return null

        // y = a+b 2y = a+b + kc
        // a+b = kc
        // a = kc - b
        var start = head
        while (start != slow) {
            start = start?.next
            slow = slow?.next
        }

        return start
    }
}
