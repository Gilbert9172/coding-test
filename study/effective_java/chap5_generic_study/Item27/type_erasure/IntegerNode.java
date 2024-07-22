package effective_java.chap5_generic_study.Item27.type_erasure;

class IntegerNode extends Node<Integer> {
    public IntegerNode(Integer data) {
        super(data);
    }

    @Override
    public void setData(Integer data) {
        System.out.println("IntegerNode 클래스의 메서드 호출");
        this.data = data + 1000;
    }
}