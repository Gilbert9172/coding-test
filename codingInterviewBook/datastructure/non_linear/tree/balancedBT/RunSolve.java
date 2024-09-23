package datastructure.non_linear.tree.balancedBT;

public class RunSolve {
    public static void main(String[] args) {
        TreeNode n4_1 = new TreeNode(4, null, null);
        TreeNode n4_2 = new TreeNode(4, null, null);

        TreeNode n3_1 = new TreeNode(3, n4_1, null);
        TreeNode n3_2 = new TreeNode(3, null, n4_2);

//        TreeNode n3_1 = new TreeNode(3, null, null);
//        TreeNode n3_2 = new TreeNode(3, null, null);
        TreeNode n2_1 = new TreeNode(2, n3_1, null);
        TreeNode n2_2 = new TreeNode(2, null, n3_2);
        TreeNode root = new TreeNode(1, n2_1, n2_2);
        V1 v1 = new V1();
        boolean isBalanced = v1.isBalanced(root);
        System.out.println(isBalanced);

    }
}
