package dfs.easy.quiz543;

import dfs.model.TreeNode;

/**
 * 풀이 전략
 * 1. root.left의 최대 깊이와 root.right의 최대 깊이를 구하여 더한다.
 * 2. 현재 노드의 diameter를 longest 변수에 담는다.
 */
public class V1 {

    int longest = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return longest;
    }

    public int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = maxDepth(node.left);
        int rightDepth = maxDepth(node.right);
        this.longest = Math.max(longest, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = testSet();

        V1 v1 = new V1();
        int answer = v1.diameterOfBinaryTree(root);
        System.out.println(answer);
    }

    private static TreeNode testSet() {
        TreeNode n7 = new TreeNode(7);
        TreeNode n2 = new TreeNode(2);
        TreeNode n11 = new TreeNode(11, n7, n2);

        TreeNode n1 = new TreeNode(1);
        TreeNode n4_1 = new TreeNode(4, n11, null);

        TreeNode n4_2 = new TreeNode(4, null, n1);
        TreeNode n13 = new TreeNode(13);
        TreeNode n8 = new TreeNode(8, n13, n4_2);
        return new TreeNode(5, n4_1, n8);
    }
}
