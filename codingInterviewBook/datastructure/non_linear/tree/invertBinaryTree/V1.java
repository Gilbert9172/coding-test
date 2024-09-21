package datastructure.non_linear.tree.invertBinaryTree;

// 신규노드 생성 DFS
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
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode inverted = new TreeNode(root.val);
        inverted.left = invertTree(root.right);
        inverted.right = invertTree(root.left);
        return inverted;
    }
}
