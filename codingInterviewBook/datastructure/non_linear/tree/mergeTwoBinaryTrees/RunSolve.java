package datastructure.non_linear.tree.mergeTwoBinaryTrees;

public class RunSolve {
    public static void main(String[] args) {
        TreeNode r1_n5 = new TreeNode(5, null, null);
        TreeNode r1_n4 = new TreeNode(4, r1_n5, null);
        TreeNode r1_n2 = new TreeNode(2, null, null);
        TreeNode root1 = new TreeNode(1, r1_n4, r1_n2);


        TreeNode r2_n7 = new TreeNode(7, null, null);
        TreeNode r2_n4 = new TreeNode(4, null, null);
        TreeNode r2_n3 = new TreeNode(3, null, r2_n7);
        TreeNode r2_n1 = new TreeNode(1, null, r2_n4);
        TreeNode root2 = new TreeNode(2, r2_n1, r2_n3);

        V1 v1 = new V1();
        TreeNode answer = v1.mergeTrees(root1, root2);
        System.out.println("break_point" + answer.toString());

        V2 v2 = new V2();
        TreeNode answer2 = v2.mergeTrees(root1, root2);
        System.out.println("break_point" + answer2.toString());
    }
}
