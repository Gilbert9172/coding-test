package tree.easy.quiz226.kotliln

import tree.easy.quiz226.kotliln.KtSolutionV1.TreeNode

fun main() {
    val node2 = TreeNode(2).apply {
        left = TreeNode(1)
        right = TreeNode(3)
    }

    val node7 = TreeNode(7).apply {
        left = TreeNode(6)
        right = TreeNode(9)
    }

    val root = TreeNode(4).apply {
        left = node2
        right = node7
    }

    KtSolutionV1().invertTree(root).apply {
        println(this?.right?.`val`)
        println(this?.left?.`val`)
    }
}

class KtSolutionV1 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return null
        val leftNode = invertTree(root.left)
        val rightNode = invertTree(root.right)
        root.left = rightNode
        root.right = leftNode
        return root
    }
}
