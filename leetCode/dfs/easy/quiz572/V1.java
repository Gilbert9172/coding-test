package dfs.easy.quiz572;

import dfs.TreeNode;

public class V1 {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (isSameTree(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.val != t.val) {
            return false;
        }
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }

    public static void main(String[] args) {
        V1 v1 = new V1();
        boolean answer = v1.isSubtree(testSet(), subSet());
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

    private static TreeNode subSet() {
        TreeNode n1 = new TreeNode(1);
        return new TreeNode(4, null, n1);
    }
}
