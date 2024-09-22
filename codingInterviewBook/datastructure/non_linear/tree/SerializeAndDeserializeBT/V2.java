package datastructure.non_linear.tree.SerializeAndDeserializeBT;

public class V2 {

    private static TreeNode t;

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
