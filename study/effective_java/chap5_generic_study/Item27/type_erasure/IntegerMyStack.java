package effective_java.chap5_generic_study.Item27.type_erasure;

public class IntegerMyStack extends MyStack<Integer> {

    public IntegerMyStack(int capacity) {
        super(capacity);
    }

    public void push(Integer value) {
        super.push(value);
    }
}
