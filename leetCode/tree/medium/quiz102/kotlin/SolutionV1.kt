package tree.medium.quiz102.kotlin

import tree.medium.quiz102.kotlin.SolutionV1.TreeNode

fun main() {
    val n9 = TreeNode(9)
    val n15 = TreeNode(15)
    val n7 = TreeNode(7)
    val n20 = TreeNode(20).apply {
        left = n15
        right = n7
    }
    val root = TreeNode(3).apply {
        left = n9
        right = n20
    }

    SolutionV1().levelOrder(root).forEach { println(it.toString()) }
}

class SolutionV1 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val res = mutableListOf<MutableList<Int>>()
        if (root == null) return res

        val que = ArrayDeque<TreeNode>()
        que.addLast(root)

        while (que.isNotEmpty()) {
            val level = mutableListOf<Int>()

            for (i in 0 until que.size) {
                val node = que.removeFirst()
                level.add(node.`val`)

                if (node.left != null) {
                    que.addLast(node.left!!)
                }

                if (node.right != null) {
                    que.addLast(node.right!!)
                }
            }
            res.add(level)
        }
        return res
    }
}
