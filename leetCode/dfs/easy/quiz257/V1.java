package dfs.easy.quiz257;

import dfs.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class V1 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        dfs(root, paths, "");
        return paths;
    }

    public void dfs(TreeNode node, List<String> paths, String path) {
        if (node.left == null && node.right == null) {
            paths.add(path + node.val);
            return;
        }

        if (node.left != null) {
            dfs(node.left, paths, path + node.val + "->");
        }

        if (node.right != null) {
            dfs(node.right, paths, path + node.val + "->");
        }
    }

    public static void main(String[] args) {
        TreeNode root = testSet();

        V1 v1 = new V1();
        List<String> paths = v1.binaryTreePaths(root);
        paths.forEach(System.out::println);
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
