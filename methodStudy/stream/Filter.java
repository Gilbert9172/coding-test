package stream;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Filter {

    public static void main(String[] args) {

        int[] lst = {1, 2, 3, 4, 5, 6, 7};

        Arrays.stream(lst)
                .boxed()
                .filter(i -> i > 4).collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
