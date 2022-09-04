package stream;

import java.util.Comparator;
import java.util.List;

public class StreamSorted {
    public static void main(String[] args) {
        List.of(4, 6, 1, 2, 10, 7).stream().sorted().forEach(System.out::println);
        System.out.println("===");
        List.of(4, 6, 1, 2, 10, 7).stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }
}

