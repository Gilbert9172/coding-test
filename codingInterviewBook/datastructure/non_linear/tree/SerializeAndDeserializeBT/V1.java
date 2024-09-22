package datastructure.non_linear.tree.SerializeAndDeserializeBT;

import java.util.*;

public class V1 {
    private final String nullLetter = "X";
    private final String splitter = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        StringBuilder builder = new StringBuilder();
        builder.append(root.val);
        while (!q.isEmpty()) {
            TreeNode node = q.remove();
            if (node.left != null) {
                q.offer(node.left);
                builder.append(splitter).append(node.left.val);
            } else {
                builder.append(splitter).append(nullLetter);
            }
            if (node.right != null) {
                q.offer(node.right);
                builder.append(splitter).append(node.right.val);
            } else {
                builder.append(splitter).append(nullLetter);
            }
        }
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] dataArray = data.split(splitter);
        TreeNode root = new TreeNode(Integer.parseInt(dataArray[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int index = 1;
        while (!q.isEmpty()) {
            if (index > dataArray.length - 1) {
                break;
            }
            TreeNode node = q.poll();
            // index → 홀수 → 왼쪽 노드
            if (index % 2 == 1) {
                String value = dataArray[index];
                if (value.equals("X")) {
                    node.left = null;
                } else {
                    node.left = new TreeNode(Integer.parseInt(value));
                    q.offer(node.left);
                }
                index++;
            }

            // index → 짝수 → 오른쪽 노드
            if (index % 2 == 0) {
                String value = dataArray[index];
                if (value.equals("X")) {
                    node.right = null;
                } else {
                    node.right = new TreeNode(Integer.parseInt(dataArray[index]));
                    q.offer(node.right);
                }
                index++;
            }

        }
        return root;
    }
}
