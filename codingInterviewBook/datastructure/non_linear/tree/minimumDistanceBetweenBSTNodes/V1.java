package datastructure.non_linear.tree.minimumDistanceBetweenBSTNodes;

public class V1 {

    private int prev = Integer.MIN_VALUE + 10000;
    private int minDiff = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        if (root != null) {
            minDiffInBST(root.left);
            minDiff = Math.min(minDiff, root.val - prev);
            prev = root.val;
            minDiffInBST(root.right);
        }
        return minDiff;
    }
}
