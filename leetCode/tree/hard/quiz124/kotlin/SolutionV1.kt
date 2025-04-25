package tree.hard.quiz124.kotlin

import tree.hard.quiz124.kotlin.SolutionV1.TreeNode

fun main() {
    val n9 = TreeNode(9)
    val n15 = TreeNode(15)
    val n7 = TreeNode(7)
    val n20 = TreeNode(20).apply {
        left = n15
        right = n7
    }
    val root = TreeNode(-10).apply {
        left = n9
        right = n20
    }

    SolutionV1().maxPathSum(root)
}

class SolutionV1 {

    private var max = 0

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun maxPathSum(root: TreeNode?): Int {
        helper(root)
        return max
    }

    private fun helper(root: TreeNode?): Int {
        if (root == null) return 0

        val left = maxOf(helper(root.left), 0)
        val right = maxOf(helper(root.right), 0)

        max = maxOf(max, root.`val` + left + right)

        return root.`val` + maxOf(left, right)
    }
}
