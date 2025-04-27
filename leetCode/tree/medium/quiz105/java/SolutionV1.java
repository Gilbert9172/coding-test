package tree.medium.quiz105.java;

import tree.medium.quiz105.TreeNode;

// 전위 순회 & 중위 순회
public class SolutionV1 {
    private int[] preOrder;
    private int[] inOrder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preOrder = preorder;
        inOrder = inorder;
        return dfs(0, 0, inOrder.length - 1);
    }

    /**
     * @param preIdx  현재 전위순회 배열에서 확인하고 있는 인덱스
     * @param inStart 중위순회 배열의 0번째 인덱스 값
     * @param inEnd   중위순회 배열의 마지막 인덱스 값
     * @return TreeNode
     */
    private TreeNode dfs(int preIdx, int inStart, int inEnd) {
        // 예외 처리
        if (preIdx > preOrder.length - 1 || inStart > inEnd) {
            return null;
        }

        // Step1. 전위순회 배열의 요소가 중위순회 배열의 몇 번째 인덱스에 위치하는지 찾기
        int inIdx = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (preOrder[preIdx] == inOrder[i]) {
                inIdx = i;
            }
        }

        // Step2. inIdx를 중위순회를 분할하는 Root 노드로 지정
        TreeNode node = new TreeNode(inOrder[inIdx]);

        // Step3. 전위순회 idx 갱신
        preIdx++;

        // Step4.
        node.left = dfs(preIdx, inStart, inIdx - 1);
        node.right = dfs(preIdx + inIdx - inStart, inIdx + 1, inEnd);


        return node;
    }
}
