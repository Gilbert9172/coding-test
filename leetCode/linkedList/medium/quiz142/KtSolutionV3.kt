package linkedList.medium.quiz142

class KtSolutionV3 {

    data class ListNode(val `val`: Int) {
        var next: ListNode? = null
    }

    fun detectCycle(head: ListNode?): ListNode? {
        val visited = HashSet<ListNode>()
        var cur = head

        while (cur != null) {
            if (visited.contains(cur)) {
                return cur
            }
            visited.add(cur)
            cur = cur.next
        }

        return null

    }
}
