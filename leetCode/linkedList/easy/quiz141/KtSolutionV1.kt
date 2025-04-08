package linkedList.easy.quiz141

/**
 * [141. Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)
 */
class KtSolutionV1 {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun hasCycle(head: ListNode?): Boolean {

        var turtle = head
        var rabbit = head

        while (rabbit?.next != null) {
            turtle = turtle?.next
            rabbit = rabbit.next?.next
            if (turtle == rabbit) return true
        }

        return false
    }
}
