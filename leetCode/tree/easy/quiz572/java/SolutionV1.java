package tree.easy.quiz572.java;

public class SolutionV1 {
    public static void main(String[] args) {
        TreeNode n4 = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        TreeNode root = new TreeNode(3, n4, new TreeNode(5));
        TreeNode subRoot = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        boolean answer = new SolutionV1().isSubtree(root, subRoot);
        System.out.println(answer);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (dfs(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean dfs(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        if (root.val != subRoot.val) return false;
        return dfs(root.left, subRoot.left) && dfs(root.right, subRoot.right);
    }

}
