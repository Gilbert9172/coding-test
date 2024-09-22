package datastructure.non_linear.tree.SerializeAndDeserializeBT;

public class RunSolve {
    public static void main(String[] args) {
        TreeNode r1_n5 = new TreeNode(5, null, null);
        TreeNode r1_n4 = new TreeNode(4, null, null);
        TreeNode r1_n3 = new TreeNode(3, r1_n4, r1_n5);
        TreeNode r1_n2 = new TreeNode(2, null, null);
        TreeNode root1 = new TreeNode(1, r1_n2, r1_n3);

//        TreeNode r1_n5 = new TreeNode(-3, null, null);
//        TreeNode r1_n4 = new TreeNode(-7, null, null);
//        TreeNode r1_n3 = new TreeNode(-5, r1_n4, r1_n5);
//        TreeNode r1_n2 = new TreeNode(-10, null, null);
//        TreeNode root1 = new TreeNode(-1, r1_n2, r1_n3);

        V1 v1 = new V1();
        String serialized = v1.serialize(root1);
        TreeNode deserialized = v1.deserialize(serialized);
        System.out.println("===");
    }
}
