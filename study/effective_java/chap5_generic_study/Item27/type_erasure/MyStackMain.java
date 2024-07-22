package effective_java.chap5_generic_study.Item27.type_erasure;

public class MyStackMain {
    public static void main(String[] args) {
        IntegerMyStack integerStack = new IntegerMyStack(5);
        MyStack<Integer> myStack = integerStack;
        myStack.push(10);
        Integer data = integerStack.pop();
        System.out.println(data);
    }
}
