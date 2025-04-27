package tree.medium.quiz105.java;

import tree.medium.quiz105.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class SolutionV3 {

    public static void main(String[] args) {
        TreeNode n7 = new TreeNode(7);
        TreeNode n15 = new TreeNode(15);
        TreeNode n20 = new TreeNode(20, n15, n7);
        TreeNode n9 = new TreeNode(9, null, null);
        TreeNode root = new TreeNode(3, n9, n20);

        int[] preOrder = new int[]{3, 9, 20, 15, 7};
        int[] inOrder = new int[]{9, 3, 15, 20, 7};
        TreeNode answer = new SolutionV3().buildTree(preOrder, inOrder);
        System.out.println(answer.val);
    }

    private Map<Integer, Integer> inMap;
    private int preIdx = 0;
    private int[] preOrder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preOrder = preorder;
        inMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return dfs(0, inorder.length - 1);
    }

    private TreeNode dfs(int start, int end) {
        if (start > end) return null;

        int rootVal = preOrder[preIdx++];
        TreeNode node = new TreeNode(rootVal);

        Integer inIdx = inMap.get(rootVal);

        node.left = dfs(start, inIdx - 1);
        node.right = dfs(inIdx + 1, end);

        return node;
    }
}
