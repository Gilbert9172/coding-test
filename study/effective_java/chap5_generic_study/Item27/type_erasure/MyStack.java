package effective_java.chap5_generic_study.Item27.type_erasure;

public class MyStack<E> {
    private E[] stackContent;

    public MyStack(int capacity) {
        this.stackContent = (E[]) new Object[capacity];
    }

    public void push(E data) {
        this.stackContent[0] = data;
    }

    public E pop() {
        return this.stackContent[0];
    }
}
