package datastructure.non_linear.tree.minimumDistanceBetweenBSTNodes;

public class RunSolve {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1, null, null);
        TreeNode n3 = new TreeNode(3, null, null);
        TreeNode n2 = new TreeNode(2, n1, n3);
        TreeNode n6 = new TreeNode(6, null, null);
        TreeNode root = new TreeNode(4, n2, n6);

        TreeNode n52 = new TreeNode(52, null, null);
        TreeNode n89 = new TreeNode(89, null, null);
        TreeNode n49 = new TreeNode(49, null, n52);
        TreeNode n69 = new TreeNode(69, n49, n89);
        TreeNode root2 = new TreeNode(90, n69, null);


        V1 solution = new V1();
        int answer = solution.minDiffInBST(root2);
        System.out.println(answer);
    }
}
