package tree.medium.quiz102.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionV1 {

    public static void main(String[] args) {
        TreeNode n9 = new TreeNode(9);
        TreeNode n15 = new TreeNode(15);
        TreeNode n7 = new TreeNode(7);
        TreeNode n20 = new TreeNode(20, n15, n7);
        TreeNode root = new TreeNode(3, n9, n20);

        List<List<Integer>> answer = new SolutionV1().levelOrder(root);
        for (List<Integer> integers : answer) {
            System.out.println(integers.toString());
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        while (!que.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int cnt = que.size();

            for (int i = 0; i < cnt; i++) {
                TreeNode node = que.poll();
                level.add(node.val);
                if (node.left != null) {
                    que.add(node.left);
                }
                if (node.right != null) {
                    que.add(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
