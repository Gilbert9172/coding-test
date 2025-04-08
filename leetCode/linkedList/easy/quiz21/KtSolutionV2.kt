package linkedList.easy.quiz21

fun main() {
    val solution = KtSolutionV2()
    val list1 = solution.createLinkedList(listOf(1, 2, 5))
    val list2 = solution.createLinkedList(listOf(1, 3, 4))

    val answer = solution.mergeTwoLists(list1, list2)
}

class KtSolutionV2 {

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
        if (list1 == null) return list2
        if (list2 == null) return list1

        return if (list1.`val` < list2.`val`) {
            list1.next = mergeTwoLists(list1, list2.next)
            list1
        } else {
            list2.next = mergeTwoLists(list1.next, list2)
            list2
        }
    }
}
