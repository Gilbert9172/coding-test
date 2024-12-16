package dfs.medium.quiz129;

import dfs.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SolutionV1 {

    List<Integer> answer = new ArrayList<>();

    public int sumNumbers(TreeNode root) {
        List<Integer> bucket = new ArrayList<>();
        bucket.add(root.val);
        backTracking(root, bucket);
        return answer.stream().mapToInt(Integer::intValue).sum();
    }

    private void backTracking(TreeNode node, List<Integer> bucket) {
        if (node.left != null) {
            bucket.add(node.left.val);
            backTracking(node.left, bucket);
            bucket.removeLast();
        }

        if (node.right != null) {
            bucket.add(node.right.val);
            backTracking(node.right, bucket);
            bucket.removeLast();
        }
        if (node.left == null && node.right == null) {
            answer.add(bucketToInt(bucket));
        }
    }

    private int bucketToInt(List<Integer> bucket) {
        long sum = 0;
        for (int i = 0; i < bucket.size(); i++) {
            long pow = (long) Math.pow(10, (long) bucket.size() - i - 1);
            sum += bucket.get(i) * pow;
        }
        return (int) sum;
    }

    public static void main(String[] args) {
        TreeNode n5 = new TreeNode(5);
        TreeNode n1 = new TreeNode(1);
        TreeNode n9 = new TreeNode(9, n5, n1);

        TreeNode n0 = new TreeNode(0);
        TreeNode root = new TreeNode(4, n9, n0);

        SolutionV1 solution = new SolutionV1();
        int answer = solution.sumNumbers(root);
        System.out.println(answer);
    }
}
