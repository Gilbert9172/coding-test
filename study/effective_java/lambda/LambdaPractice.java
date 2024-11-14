package effective_java.lambda;

import java.util.function.Function;

public class LambdaPractice {
    public static void main(String[] args) {

        Function<Integer, Integer> function1 = x  -> x + 10;
        Function<Integer, Integer> function2 = x  -> x - 10;

        System.out.println(apply(10, function1));
        System.out.println(apply(10, function2));

        System.out.println(function1.hashCode());
        System.out.println(function2.hashCode());

        System.out.println(function1.equals(function2));

    }

    public static int apply(int x, Function<Integer, Integer> function) {
        return function.apply(x);
    }
}