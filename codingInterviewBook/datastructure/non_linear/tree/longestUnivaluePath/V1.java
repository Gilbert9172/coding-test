package datastructure.non_linear.tree.longestUnivaluePath;

public class V1 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public boolean isEqual(TreeNode node) {
            return node != null && val == node.val;
        }
    }

    private int maxLength = 0;

    public int longestUnivaluePath(TreeNode root) {
        depth(root);
        return maxLength;
    }

    private int depth(TreeNode node) {
        if (node == null) return 0;
        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);
        if (node.isEqual(node.left)) {
            leftDepth ++;
        } else {
            leftDepth = 0;
        }
        if (node.isEqual(node.right)) {
            rightDepth ++;
        } else {
            rightDepth = 0;
        }

        maxLength = Math.max(maxLength, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth);
    }
}
