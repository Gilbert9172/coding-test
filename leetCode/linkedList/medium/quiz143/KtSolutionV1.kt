package linkedList.medium.quiz143

import linkedList.ListNode

fun main() {
    val head = ListNode.createLinkedList(listOf(1, 2, 3, 4, 5))
    KtSolutionV1().reorderList(head)
}

class KtSolutionV1 {
    fun reorderList(head: ListNode?): Unit {
        val memo = head

        var origin = head
        var reverseNode = reverseNode(memo)

        val dummy = ListNode(0)
        var tail: ListNode? = dummy

        while (true) {
            val oNext = origin?.next
            tail?.next = origin
            tail = origin
            origin = oNext


            val rNext = reverseNode?.next
            if (tail?.`val` == reverseNode?.`val`) {
                tail?.next = null
            } else {
                tail?.next = reverseNode
                tail = reverseNode
                reverseNode = rNext
            }
        }
    }

    private fun reverseNode(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var cur: ListNode? = head

        while (cur != null) {
            val next = cur.next
            cur.next = prev
            prev = cur
            cur = next
        }

        return prev
    }
}
