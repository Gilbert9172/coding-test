package tree.easy.quiz100.kotlin

import tree.easy.quiz100.kotlin.KtSolutionV1.TreeNode

fun main() {
    val p = TreeNode(1).apply {
        left = TreeNode(2)
        right = TreeNode(3)
    }

    val q = TreeNode(1).apply {
        left = TreeNode(2)
        right = TreeNode(3)
    }

    KtSolutionV1().isSameTree(p, q).apply {
        println(this)
    }

}

class KtSolutionV1 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) return true

        if (p != null && q != null && p.`val` == q.`val`) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
        }

        return true
    }
}
