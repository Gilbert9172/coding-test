package linkedList.medium.quiz142

class KtSolutionV1 {

    data class ListNode(val `val`: Int) {
        var next: ListNode? = null
    }

    fun detectCycle(head: ListNode?): ListNode? {
        var slow = head
        var fast = head

        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next

            if (slow == fast) {
                var pointer1 = head
                var pointer2 = fast

                while (pointer1 != pointer2) {
                    pointer1 = pointer1?.next
                    pointer2 = pointer2?.next
                }
                return pointer1
            }
        }
        return null
    }
}
