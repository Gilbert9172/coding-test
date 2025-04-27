package tree.easy.quiz572.kotlin

class SolutionV1 {
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (root == null) return false
        if (isSame(root, subRoot)) return true
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)
    }

    private fun isSame(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (root == null && subRoot == null) return true
        if (root == null || subRoot == null) return false
        if (root.`val` != subRoot.`val`) return false
        return isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right)
    }
}
