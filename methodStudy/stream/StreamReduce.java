package stream;

import java.util.Arrays;

/**
 * 스트림의 요소를 줄여 나가면서 연산을 수행하고 최종 결과를 반환.
 * 처음 두 요소를 가지고 연산한 결과를 사용해 다음 요소와 연산한다.
 * 초기값을 주는 경우는 초기값과 스트림의 첫 번쨰 요소로 연산을 시작하고,
 * 연산한 결과를 사용해 다음 요소와 연산한다.
 */
public class StreamReduce {

    public static void main(String[] args) {

        int[] arr = {1,2,3};
        int result = Arrays.stream(arr).reduce(5, (a, b) -> a + b);
        System.out.println(result);
    }
}
