package datastructure.non_linear.tree.rangeSumOfBST;

public class V2 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        return accNode(root, low, high);
    }

    private int accNode(TreeNode root, int low, int high) {
        if (root == null) return 0;
        int acc = 0;
        int target = root.val;
        if (target >= low && target <= high) {
            acc += target;
        }
        if (target > low) {
            acc += accNode(root.left, low, high);
        }
        if (target < high) {
            acc += accNode(root.right, low, high);

        }
        return acc;
    }
}
