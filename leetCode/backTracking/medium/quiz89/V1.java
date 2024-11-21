package backTracking.medium.quiz89;

import java.util.List;
import java.util.stream.IntStream;

// 89. Gray Code
public class V1 {

    public List<Integer> grayCode(int n) {
        return IntStream.range(0, (int) Math.pow(2, n))
                .map(i -> i ^ (i >> 1))
                .boxed()
                .toList();
    }

    public static void main(String[] args) {
        int input = 3;
        V1 v1 = new V1();
        List<Integer> answer = v1.grayCode(input);
        System.out.println(answer.toString());
    }
}
