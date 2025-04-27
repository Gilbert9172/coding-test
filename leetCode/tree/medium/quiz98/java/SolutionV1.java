package tree.medium.quiz98.java;

public class SolutionV1 {
    public static void main(String[] args) {
        TreeNode n3 = new TreeNode(3);
        TreeNode n6 = new TreeNode(6);
        TreeNode n4 = new TreeNode(4, n3, n6);
        TreeNode n1 = new TreeNode(1);
        TreeNode root = new TreeNode(5, n1, n4);

        boolean answer = new SolutionV1().validate(root, null, null);
        System.out.println(answer);
    }

    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    public boolean validate(TreeNode node, Integer minVal, Integer maxVal) {
        if (node == null) return true;

        if ((minVal != null && node.val <= minVal) || (maxVal != null && node.val >= maxVal)) {
            return false;
        }

        boolean left = validate(node.left, minVal, node.val);
        boolean right = validate(node.right, node.val, maxVal);

        return left && right;
    }
}
