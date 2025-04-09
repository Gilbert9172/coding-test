package linkedList.hard.quiz23

import linkedList.ListNode
import java.util.*

fun main() {
    val lists = arrayOf(
        ListNode.createLinkedList(listOf(1, 4, 5)),
        ListNode.createLinkedList(listOf(1, 3, 4)),
        ListNode.createLinkedList(listOf(2, 6))
    )
    KtSolutionV1().mergeKLists(lists)
}

class KtSolutionV1 {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) return null

        val pq = PriorityQueue<Int>()

        for (list in lists) {
            var cur = list
            while (cur != null) {
                pq.offer(cur.`val`)
                cur = cur.next
            }
        }

        val result = ListNode(Int.MIN_VALUE)
        var prev = result
        while (pq.isNotEmpty()) {
            val node = ListNode(pq.poll())
            prev.next = node
            prev = node
        }

        return result.next
    }
}
