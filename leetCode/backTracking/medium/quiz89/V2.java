package backTracking.medium.quiz89;

import java.util.List;
import java.util.stream.IntStream;

// 89. Gray Code
public class V2 {

    public List<Integer> grayCode(int n) {
        return IntStream.range(0, (int) Math.pow(2, n))
                .map(this::generateGrayCode)
                .boxed()
                .toList();
    }

    private Integer generateGrayCode(int n) {
        if (n < 2) {
            return n;
        }

        String binaryString = Integer.toBinaryString(n);
        List<Integer> tokens = binaryString.chars()
                .mapToObj(Character::toString)
                .map(Integer::parseInt)
                .toList();

        StringBuilder builder = new StringBuilder();
        builder.append(tokens.getFirst());
        for (int i = 0; i < tokens.size() - 1; i++) {
            String value = String.valueOf(tokens.get(i) ^ tokens.get(i + 1));
            builder.append(value);
        }
        return Integer.parseInt(builder.toString(), 2);
    }

    public static void main(String[] args) {
        int input = 2;
        V2 v1 = new V2();
        List<Integer> answer = v1.grayCode(input);
        System.out.println(answer.toString());
    }
}
