package tree.hard.quiz297.java;

import java.util.LinkedList;
import java.util.Queue;

public class CodecV2 {
    public String serialize(TreeNode root) {
        if (root == null) return "";

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        StringBuilder builder = new StringBuilder();
        builder.append(root.val);

        while (!q.isEmpty()) {
            TreeNode node = q.remove();

            if (node.left != null) {
                q.offer(node.left);
                builder.append(",").append(node.left.val);
            } else {
                builder.append(",X");
            }

            if (node.right != null) {
                q.offer(node.right);
                builder.append(",").append(node.right.val);
            } else {
                builder.append(",X");
            }
        }
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;

        String[] dataArray = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(dataArray[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int index = 1;
        while (!q.isEmpty()) {
            if (index > dataArray.length - 1) {
                break;
            }
            TreeNode node = q.poll();
            // index가 홀수이면 왼쪽 노드
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
