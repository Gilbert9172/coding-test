package dfs.medium.quiz230;

import dfs.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SolutionV2 {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> bucket = new ArrayList<>();
        dfs(root, bucket);
        return bucket.get(k - 1);
    }

    public void dfs(TreeNode node, List<Integer> bucket) {
        if (isLeaf(node)) {
            return;
        }

        dfs(node.left, bucket);
        bucket.add(node.val);
        dfs(node.right, bucket);
    }

    private boolean isLeaf(TreeNode node) {
        return node == null;
    }

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
}
