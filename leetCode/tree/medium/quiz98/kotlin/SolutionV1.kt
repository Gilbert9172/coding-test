package tree.medium.quiz98.kotlin

class SolutionV1 {
    fun isValidBST(root: TreeNode?): Boolean {
        return validate(root, null, null)
    }

    private fun validate(node: TreeNode?, minVal: Int?, maxVal: Int?): Boolean {
        if (node == null) return true

        if ((minVal != null && minVal <= node.`val`) || (maxVal != null && maxVal >= node.`val`)) {
            return false
        }

        val left = validate(node.left, minVal, node.`val`)
        val right = validate(node.right, node.`val`, maxVal)

        return left && right
    }
}
