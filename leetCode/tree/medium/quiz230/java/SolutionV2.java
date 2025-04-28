package tree.medium.quiz230.java;

import java.util.HashMap;
import java.util.Map;

public class SolutionV2 {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2, n1, null);
        TreeNode n4 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3, n2, n4);
        TreeNode n6 = new TreeNode(6);
        TreeNode root = new TreeNode(5, n3, n6);

        SolutionV2 solution = new SolutionV2();
        int answer = solution.kthSmallest(root, 3);
        System.out.println(answer);
    }

    private final Map<Integer, Integer> nodeMap = new HashMap<>();
    private int idx = 1;

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root);
        return nodeMap.get(k);
    }

    private void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        nodeMap.put(idx++, node.val);
        inOrder(node.right);
    }
}
