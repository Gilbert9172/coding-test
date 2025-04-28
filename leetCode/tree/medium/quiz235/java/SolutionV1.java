package tree.medium.quiz235.java;

public class SolutionV1 {
    public static void main(String[] args) {
        TreeNode n4 = new TreeNode(4, new TreeNode(3), new TreeNode(5));
        TreeNode n2 = new TreeNode(2, new TreeNode(0), n4);
        TreeNode n8 = new TreeNode(8, new TreeNode(7), new TreeNode(9));
        TreeNode root = new TreeNode(6, n2, n8);
        TreeNode answer = new SolutionV1().lowestCommonAncestor(root, new TreeNode(2), new TreeNode(4));
        System.out.println(answer.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val > root.val && q.val > root.val) { // 오른쪽 서브 트리
                root = root.right;
            } else if (p.val < root.val && q.val < root.val) { // 왼쪽 서브 트리
                root = root.left;
            } else {
                return root;
            }
        }
        return null;
    }
}
