package datastructure.non_linear.tree.bstToGreaterSumTree;

public class RunSolve {
    public static void main(String[] args) {

        TreeNode n3 = new TreeNode(3, null, null);
        TreeNode n7 = new TreeNode(7, null, null);
        TreeNode n4 = new TreeNode(4, n3, n7);
        TreeNode n0 = new TreeNode(0, null, null);
        TreeNode n1 = new TreeNode(1, n0, null);
        TreeNode root = new TreeNode(2, n1, n4);

        V1 solution = new V1();
        TreeNode treeNode = solution.bstToGst(root);
        System.out.println("bp");
    }
}
