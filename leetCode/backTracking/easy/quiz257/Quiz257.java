package backTracking.easy.quiz257;

import java.util.ArrayList;
import java.util.List;

public class Quiz257 {


    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<>();
        findRoute(root, "", answer);
        return answer;
    }

    private void findRoute(TreeNode root, String path, List<String> answer) {
        if (root.left == null && root.right == null) {
            answer.add(path + root.val);
        }

        if (root.left != null) {
            findRoute(root.left, path + root.val + "->", answer);
        }

        if (root.right != null) {
            findRoute(root.right, path + root.val + "->", answer);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = setUp();
        Quiz257 quiz257 = new Quiz257();
        List<String> nodeValues = quiz257.binaryTreePaths(treeNode);
        for (String nodeValue : nodeValues) {
            System.out.println(nodeValue);
        }
    }

    private static TreeNode setUp() {
        TreeNode node5 = TreeNode.of(5, null, null);
        TreeNode node4 = TreeNode.of(4, null, null);
        TreeNode node3 = TreeNode.of(3, null, null);
        TreeNode node2 = TreeNode.of(2, node4, node5);
        return TreeNode.of(1, node2, node3);
    }
}
