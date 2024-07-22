package effective_java.chap5_generic_study.Item29;

import effective_java.chap5_generic_study.StackV3;

public class RunItem29 {
    public static void main(String[] args) {
        StackV3<String> stack = new StackV3<>();
        for (String arg : args)
            stack.push(arg);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop().toUpperCase());
        }
    }
}
