package backTracking.easy.quiz257;

public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public static TreeNode from(int val) {
        return new TreeNode(val);
    }

    public static TreeNode of(int val, TreeNode left, TreeNode right) {
        return new TreeNode(val, left, right);
    }

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
