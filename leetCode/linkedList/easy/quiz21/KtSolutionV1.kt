package linkedList.easy.quiz21

/**
 * [21. Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/description/)
 */
fun main() {
    val solution = KtSolutionV1()
    val list1 = solution.createLinkedList(listOf(1, 2, 5))
    val list2 = solution.createLinkedList(listOf(1, 3, 4))

    val answer = solution.mergeTwoLists(list1, list2)
}

class KtSolutionV1 {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

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

    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var head1 = list1
        var head2 = list2
        val emptyNode = ListNode(-1)
        var prev = emptyNode

        while (head1?.`val` != null || head2?.`val` != null) {
            if (head1 == null || head2 == null) {
                prev.next = head1 ?: head2
                break
            } else if (head1.`val` > head2.`val`) {
                prev.next = ListNode((head2.`val`))
                head2 = head2.next
                prev = prev.next!!
            } else if (head1.`val` < head2.`val`) {
                prev.next = ListNode(head1.`val`)
                head1 = head1.next
                prev = prev.next!!
            } else {
                prev.next = ListNode(head1.`val`)
                prev.next?.next = ListNode(head2.`val`)
                head1 = head1.next
                head2 = head2.next
                prev = prev.next!!.next!!
            }
        }

        return emptyNode.next
    }
}
