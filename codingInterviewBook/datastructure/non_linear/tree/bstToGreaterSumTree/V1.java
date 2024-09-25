package datastructure.non_linear.tree.bstToGreaterSumTree;

public class V1 {
    int val = 0;
    public TreeNode bstToGst(TreeNode root) {
        if (root != null) {
            bstToGst(root.right);
            val += root.val;
            root.val = val;
            bstToGst(root.left);
        }
        return root;
    }
}
