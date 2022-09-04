package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// flatmap 메서드는 중첩된 구조를 한 단계 없애고 단일 원소 스트림으로 만들어준다.
public class StreamFlatMap {

    public static void main(String[] args) {

        List<String> list1 = List.of("jung", "gilbert");
        List<String> list2 = List.of("kim", "gilbert");
        List<List<String>> combinedList = List.of(list1, list2);

        combinedList.stream()
                    .flatMap(list -> list.stream())
                    .filter(x -> "jung".equals(x))
                    .collect(Collectors.toList())
                    .forEach(System.out::println);

        System.out.println("====");

        // 2차원 배열
        String[][] arrays = new String[][]{
                {"jung", "gilbert"}, {"kim", "gilbert"}
        };

        Arrays.stream(arrays)
                .flatMap(arr -> Arrays.stream(arr))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
