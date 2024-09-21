package datastructure.non_linear.tree.invertBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

// 반복구조 BFS
public class V5 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public boolean hasLeft() {
            return this.left != null;
        }

        public boolean hasRight() {
            return this.right != null;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.hasLeft()) {
                q.offer(node.left);
            }
            if (node.hasRight()) {
                q.offer(node.right);
            }
        }
        return root;
    }
}
