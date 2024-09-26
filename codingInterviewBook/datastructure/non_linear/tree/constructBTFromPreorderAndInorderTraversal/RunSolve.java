package datastructure.non_linear.tree.constructBTFromPreorderAndInorderTraversal;

public class RunSolve {
    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7, 9, 8};
        int[] inorder = {4, 2, 5, 1, 7, 9, 6, 8, 3};
        V1 solution = new V1();
        TreeNode answer = solution.buildTree(preorder, inorder);
        System.out.println("BP");
    }


}
