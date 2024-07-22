package effective_java.chap5_generic_study.Item27.type_erasure;

public class NodeMain {
    public static void main(String[] args) {
        IntegerNode int_node = new IntegerNode(1);
        Node node = int_node; // 업캐스팅
        node.setData("Hello");
    }
}
