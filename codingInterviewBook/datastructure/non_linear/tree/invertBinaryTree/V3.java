package datastructure.non_linear.tree.invertBinaryTree;

// 후위순위 재귀구조 DFS
public class V3 {
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
    }

    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            invertTree(root.left);  // 왼쪽 자식 노드 DFS
            invertTree(root.right); // 오른쪽 자식 노드 DFS

            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        return root;
    }
}
