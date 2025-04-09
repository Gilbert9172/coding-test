package linkedList.medium.quiz12

import linkedList.ListNode

fun main() {
    val head = ListNode.createLinkedList(listOf(1, 2))
    KtSolutionV2().removeNthFromEnd(head, 1)
}

class KtSolutionV2 {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val dummy = ListNode(0).apply { next = head }
        var fast: ListNode? = dummy
        var slow: ListNode? = dummy

        // fast 먼저 n칸 이동
        repeat(n) { fast = fast?.next }

        // fast와 slow를 같이 이동
        while (fast?.next != null) {
            fast = fast?.next
            slow = slow?.next
        }

        // 삭제
        slow?.next = slow?.next?.next

        return dummy.next
    }
}
