package datastructure.non_linear.tree.invertBinaryTree;

import java.util.ArrayDeque;
import java.util.Deque;

// 반복구조 DFS
public class V4 {
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
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.hasLeft()) {
                stack.push(node.left);
            }
            if (node.hasRight()) {
                stack.push(node.right);
            }
        }
        return root;
    }
}
