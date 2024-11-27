package dfs.easy.quiz104;

import dfs.model.TreeNode;

public class V1 {

    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode head) {
        if (head == null) {
            return 0;
        }
        int leftMax = dfs(head.left);
        int rightMax = dfs(head.right);
        return 1 + Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        TreeNode n7 = new TreeNode(7);
        TreeNode n15 = new TreeNode(15);
        TreeNode n20 = new TreeNode(20, n15, n7);

        TreeNode n9 = new TreeNode(9);
        TreeNode root = new TreeNode(3, n9, n20);

        V1 v1 = new V1();
        int answer = v1.maxDepth(root);
        System.out.println(answer);
    }
}
