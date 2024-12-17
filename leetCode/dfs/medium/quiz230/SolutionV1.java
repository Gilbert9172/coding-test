package dfs.medium.quiz230;

import dfs.TreeNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SolutionV1 {

    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(Integer::intValue));
        initiateSortedQueue(root, pq);

        int answer = 0;
        for (int i = 0; i < k; i++) {
            answer = pq.poll();
        }
        return answer;
    }

    private TreeNode initiateSortedQueue(TreeNode node, PriorityQueue<Integer> pq) {

        if (node.left != null) {
            node.left = initiateSortedQueue(node.left, pq);
        }

        if (node.right != null) {
            node.right = initiateSortedQueue(node.right, pq);
        }

        if (isLeaf(node)) {
            pq.offer(node.val);
            return null;
        }

        return node;
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2, n1, null);
        TreeNode n4 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3, n2, n4);
        TreeNode n6 = new TreeNode(6);
        TreeNode root = new TreeNode(5, n3, n6);

        SolutionV1 solution = new SolutionV1();
        int answer = solution.kthSmallest(root, 6);
        System.out.println(answer);
    }
}
