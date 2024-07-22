package effective_java.chap5_generic_study.Item27.type_erasure;

class Node<T> {
    public T data;

    public Node(T data) {
        this.data = data;
    }

    public void setData(T data) {
        System.out.println("Node<T> 클래스의 메서드 호출");
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
