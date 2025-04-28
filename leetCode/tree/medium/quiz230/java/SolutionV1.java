package tree.medium.quiz230.java;

import java.util.PriorityQueue;

public class SolutionV1 {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2, n1, null);
        TreeNode n4 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3, n2, n4);
        TreeNode n6 = new TreeNode(6);
        TreeNode root = new TreeNode(5, n3, n6);

        SolutionV1 solution = new SolutionV1();
        int answer = solution.kthSmallest(root, 3);
        System.out.println(answer);
    }

    private final PriorityQueue<Integer> pq = new PriorityQueue<>();

    public int kthSmallest(TreeNode root, int k) {
        iterateTree(root);

        int answer = 0;
        for (int i = 0; i < k; i++) {
            answer = pq.poll();
        }

        return answer;
    }

    private TreeNode iterateTree(TreeNode node) {
        if (node.left != null) {
            node.left = iterateTree(node.left);
        }

        if (node.right != null) {
            node.right = iterateTree(node.right);
        }

        if (isLeaf(node)) {
            pq.add(node.val);
            return null;
        }

        return node;
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
