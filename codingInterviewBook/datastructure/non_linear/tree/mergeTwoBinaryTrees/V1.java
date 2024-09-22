package datastructure.non_linear.tree.mergeTwoBinaryTrees;

public class V1 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 == null) {
            root1 = new TreeNode(0);
        }
        if (root2 == null) {
            root2 = new TreeNode(0);
        }
        TreeNode merged = new TreeNode(root1.val + root2.val);
        merged.left = mergeTrees(root1.left, root2.left);
        merged.right = mergeTrees(root1.right, root2.right);
        return merged;
    }
}
