package linkedList.medium.quiz12

import linkedList.ListNode

fun main() {
    val head = ListNode.createLinkedList(listOf(1, 2))
    KtSolutionV1().removeNthFromEnd(head, 1)
}

class KtSolutionV1 {

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head == null) return null;

        val nodeList = mutableListOf<ListNode>()
        var cur = head

        while (cur != null) {
            nodeList.add(cur)
            cur = cur.next
        }

        val result = ListNode(-1)
        var prev = result
        for ((idx, node) in nodeList.withIndex()) {
            if (nodeList.size - idx != n) {
                val listNode = ListNode(node.`val`)
                prev.next = listNode
                prev = listNode
            }
        }

        return result.next
    }
}
