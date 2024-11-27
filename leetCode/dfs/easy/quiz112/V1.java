package dfs.easy.quiz112;

import dfs.model.TreeNode;

public class V1 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        boolean left = hasPathSum(root.left, targetSum - root.val);
        boolean right = hasPathSum(root.right, targetSum - root.val);
        return left || right;
    }

    public static void main(String[] args) {
        TreeNode root = testSet2();
        int targetSum = 1;

        V1 v1 = new V1();
        boolean answer = v1.hasPathSum(root, targetSum);
        System.out.println(answer);
    }

    private static TreeNode testSet() {
        TreeNode n7 = new TreeNode(7);
        TreeNode n2 = new TreeNode(2);
        TreeNode n11 = new TreeNode(11, n7, n2);

        TreeNode n1 = new TreeNode(1);
        TreeNode n4_1 = new TreeNode(4, n11, null);

        TreeNode n4_2 = new TreeNode(4, null, n1);
        TreeNode n13 = new TreeNode(13);
        TreeNode n8 = new TreeNode(8, n13, n4_2);
        return new TreeNode(5, n4_1, n8);
    }

    private static TreeNode testSet2() {
        TreeNode n2 = new TreeNode(2, null, null);
        return new TreeNode(1, n2, null);
    }
}
