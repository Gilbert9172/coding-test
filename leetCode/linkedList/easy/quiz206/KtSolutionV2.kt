package linkedList.easy.quiz206

class KtSolutionV2 {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun reverseList(head: ListNode?): ListNode? {
        return recursive(head, null)
    }

    private fun recursive(node: ListNode?, prev: ListNode?): ListNode? {
        if (node == null) return prev
        val next = node.next
        node.next = prev
        return recursive(next, node)
    }

}
