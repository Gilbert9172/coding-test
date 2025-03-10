import java.util.List;

public class StudyStream {

    public static void main(String[] args) {
        List<Integer> upStream = List.of(1, 2, 3, 4, 5);
        upStream.stream()
                .map(v -> {
                    int newValue = v * 2;
                    System.out.println("===");
                    System.out.println("map 연산 = " + newValue);
                    return newValue;
                })
                .forEach(v -> System.out.println("foreach 연산 = " + v));
    }

}
