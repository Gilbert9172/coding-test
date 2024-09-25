package datastructure.non_linear.tree.rangeSumOfBST;

public class RunSolveV1 {
    public static void main(String[] args) {
        TreeNode n3 = new TreeNode(3, null, null);
        TreeNode n7 = new TreeNode(7, null, null);
        TreeNode n18 = new TreeNode(18, null, null);
        TreeNode n5 = new TreeNode(5, n3, n7);
        TreeNode n15 = new TreeNode(15, null, n18);
        TreeNode root = new TreeNode(10, n5, n15);

        V1 solution = new V1();
        int answer = solution.rangeSumBST(root, 7, 15);
        System.out.println(answer);
    }
}
