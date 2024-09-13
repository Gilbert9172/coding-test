package datastructure.non_linear.tree;

/**
 * <a href="https://leetcode.com/problems/diameter-of-binary-tree/">Diameter of binary tree</a>
 */
public class DiameterOfBinaryTree {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {}

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int longestPath = 0;

    public int longestPathOfBinaryTree(TreeNode root) {
        depth(root);
        return longestPath;
    }

    private int depth(TreeNode node) {
        if (node == null) return 0;

        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);

        // 두 서브트리 경로를 합한 것이 지름이 될 수 있음
        longestPath = Math.max(longestPath, leftDepth + rightDepth);

        // 현재 노드에서의 최대 깊이를 반환
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
