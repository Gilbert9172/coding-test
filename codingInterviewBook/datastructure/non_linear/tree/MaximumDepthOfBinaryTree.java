package datastructure.non_linear.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {}

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxDepth(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return depth;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // q가 빈다면 종료
        while (!q.isEmpty()) {
            depth++;
            int q_size = q.size();
            for (int i = 0; i < q_size; i++) {
                TreeNode tn = q.remove();
                if (tn.left != null) {
                    q.offer(tn.left);
                }
                if (tn.right != null) {
                    q.offer(tn.right);
                }
            }

        }
        return depth;
    }

    public int maxDepthV2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
