package dfs.medium.quiz129;

import dfs.TreeNode;

public class SolutionV2 {

    int total;

    public int sumNumbers(TreeNode root) {
        total = 0;
        helper(root, 0);
        return total;
    }

    void helper(TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        sum = sum * 10 + root.val;

        if (root.left == null && root.right == null) {
            total += sum;
            return;
        }

        helper(root.left, sum);
        helper(root.right, sum);
    }

    public static void main(String[] args) {
        TreeNode n5 = new TreeNode(5);
        TreeNode n1 = new TreeNode(1);
        TreeNode n9 = new TreeNode(9, n5, n1);

        TreeNode n0 = new TreeNode(0);
        TreeNode root = new TreeNode(4, n9, n0);

        SolutionV2 solution = new SolutionV2();
        int answer = solution.sumNumbers(root);
        System.out.println(answer);
    }
}
