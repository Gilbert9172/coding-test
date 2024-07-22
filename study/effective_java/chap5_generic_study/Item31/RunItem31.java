package effective_java.chap5_generic_study.Item31;

import effective_java.chap5_generic_study.StackV3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RunItem31 {
    public static void main(String[] args) {
        StackV3<Number> numberStack = new StackV3<>();
        List<Integer> integers = new ArrayList<>(List.of(1,2,3,4));
        numberStack.pushAll(integers);

        Collection<Object> objects = new ArrayList<>();
        numberStack.popAll(objects);

        for (Object object : objects) {
            System.out.println(object);
        }
    }
}
