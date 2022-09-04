package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayToStream {

    public static void main(String[] args) {

        String[] lst = {"a", "b", "c"};
        Stream<String> stream = Arrays.stream(lst);

        // Stream<String> ➣ List<String>
        List<String> collect = stream.collect(Collectors.toList());


        int[] lst2 = {1, 2, 3};

        // int[] ➣ IntStream
        IntStream intStream1 = Arrays.stream(lst2);
        IntStream intStream2 = IntStream.of(lst2);

        // IntStream ➣ Stream<Integer>
        Stream<Integer> intStream1Map = intStream1.mapToObj(i -> i);
        Stream<Integer> intSteam1Boxed = intStream1.boxed();

        // Stream<Integer> ➣ List<Integer>
        List<Integer> intStream1List = intStream1Map.collect(Collectors.toList());

        // List<Integer> ➣ Stream<Integer>
        Stream<Integer> stream1 = intStream1List.stream();

        // Stream<Integer> ➣ IntStream
        IntStream intStream = stream1.mapToInt(Integer::intValue);

        // IntStream ➣ int[]
        int[] intArray = intStream.toArray();

        for (int i : intArray) {
            System.out.println(i);
        }
    }

}
