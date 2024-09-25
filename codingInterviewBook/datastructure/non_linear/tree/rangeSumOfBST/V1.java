package datastructure.non_linear.tree.rangeSumOfBST;

public class V1 {

    private int acc = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        sum(root.left, low, high);
        sum(root.right, low, high);
        int target = root.val;
        if (target >= low && target <= high) {
            acc += target;
        }
        return acc ;
    }

    private void sum(TreeNode root, int low, int high) {
        if (root != null) {
            sum(root.left, low, high);
            sum(root.right, low, high);
            int target = root.val;
            if (target >= low && target <= high) {
                acc += target;
            }
        }
    }
}
