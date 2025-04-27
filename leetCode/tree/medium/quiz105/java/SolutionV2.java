package tree.medium.quiz105.java;

import tree.medium.quiz105.TreeNode;

public class SolutionV2 {
    public static void main(String[] args) {
        TreeNode n7 = new TreeNode(7);
        TreeNode n15 = new TreeNode(15);
        TreeNode n20 = new TreeNode(20, n15, n7);
        TreeNode n9 = new TreeNode(9, null, null);
        TreeNode root = new TreeNode(3, n9, n20);

        int[] preOrder = new int[]{3, 9, 20, 15, 7};
        int[] inOrder = new int[]{9, 3, 15, 20, 7};
        new SolutionV2().buildTree(preOrder, inOrder);
    }

    private int preIndex = 0; // 전역 preIndex
    private int[] preOrder;
    private int[] inOrder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preOrder = preorder;
        inOrder = inorder;
        return dfs(0, inorder.length - 1);
    }

    private TreeNode dfs(int inStart, int inEnd) {
        // 예외 처리
        if (inStart > inEnd) {
            return null;
        }

        // preorder[preIndex]를 현재 루트로 삼는다
        int rootVal = preOrder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        // inorder에서 현재 루트(rootVal)의 위치 찾기
        int inIndex = findInorderIndex(rootVal, inStart, inEnd);

        // 왼쪽 서브트리
        root.left = dfs(inStart, inIndex - 1);

        // 오른쪽 서브트리
        root.right = dfs(inIndex + 1, inEnd);

        return root;
    }

    private int findInorderIndex(int target, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (inOrder[i] == target) {
                return i;
            }
        }
        // 문제 조건 상 항상 존재한다고 가정하니 따로 예외처리는 안 해도 됨
        return -1;
    }
}
