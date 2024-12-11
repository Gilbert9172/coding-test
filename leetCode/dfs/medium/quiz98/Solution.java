package dfs.medium.quiz98;

import dfs.TreeNode;

// 🔥핵심 Point : 범위를 설정해라.
// ⏰시간 복잡도 : O(n), n = 노드의 갯수
public class Solution {

    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    public boolean validate(TreeNode node, Integer minVal, Integer maxVal) {
        if (node == null) {
            return true;
        }

        if ((minVal != null && node.val <= minVal) || (maxVal != null && node.val >= maxVal)) {
            return false;
        }

        boolean left = validate(node.left, minVal, node.val);
        boolean right = validate(node.right, node.val, maxVal);
        return left && right;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1, null, null);
        TreeNode t4 = new TreeNode(4, t1, null);
        TreeNode t5 = new TreeNode(5, null, null);
        TreeNode t9 = new TreeNode(9, null, null);
        TreeNode t8 = new TreeNode(8, t5, t9);
        TreeNode root = new TreeNode(6, t4, t8);
        Solution solution = new Solution();
        boolean answer = solution.isValidBST(root);
        System.out.println(answer);
    }
}
