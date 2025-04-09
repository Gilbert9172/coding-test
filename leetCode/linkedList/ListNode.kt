package linkedList

class ListNode(var `val`: Int) {

    var next: ListNode? = null

    companion object {
        fun createLinkedList(values: List<Int>): ListNode? {
            if (values.isEmpty()) return null
            val dummy = ListNode(0)
            var current = dummy
            for (value in values) {
                current.next = ListNode(value)
                current = current.next!!
            }
            return dummy.next
        }

    }
}
