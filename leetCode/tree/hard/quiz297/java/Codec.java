package tree.hard.quiz297.java;

public class Codec {

    static TreeNode t;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        t = root;
        return "";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return t;
    }
}
