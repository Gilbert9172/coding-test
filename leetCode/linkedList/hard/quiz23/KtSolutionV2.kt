package linkedList.hard.quiz23

import linkedList.ListNode
import java.util.*

fun main() {
    val lists = arrayOf(
        ListNode.createLinkedList(listOf(1, 4, 5)),
        ListNode.createLinkedList(listOf(1, 3, 4)),
        ListNode.createLinkedList(listOf(2, 6))
    )
    KtSolutionV2().mergeKLists(lists)
}


class KtSolutionV2 {

    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val pq = PriorityQueue<ListNode>(compareBy { it.`val` })

        // 각 리스트의 head를 pq에 넣음
        for (node in lists) {
            if (node != null) {
                pq.offer(node)
            }
        }

        val dummy = ListNode(0)
        var tail = dummy

        while (pq.isNotEmpty()) {
            val node = pq.poll()
            tail.next = node
            tail = node

            // 다음 노드가 있으면 pq에 넣음
            node.next?.let {
                pq.offer(it)
            }
        }

        return dummy.next
    }
}
