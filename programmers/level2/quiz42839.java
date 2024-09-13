package level2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 * 프린터
 */
public class quiz42839 {

    static HashSet<Integer> setList = new HashSet<>();
    static int answer = 0;

    public static void main(String[] args) {

        String numbers = "011";

        // String → int[]
        int[] nums = Arrays.stream(numbers.split("")).mapToInt(Integer::parseInt).toArray();

        // 순열
        for (int i = 0; i < nums.length; i++) {
            permutation(nums, new int[nums.length], new boolean[nums.length], 0, i + 1);
        }

        // 소수 찾기
        for (Integer element : setList) {
            if (isPrimeNum(element)) {
                answer ++;
            }
        }

        // 결과
        System.out.println(answer);

    }

    // DFS → 주어진 수로 만들수 있는 모든 수.(순열)
    public static void permutation(int[] nums, int[] output, boolean[] visited, int depth, int r) {

        if (depth == r) {

            int[] result = Arrays.copyOfRange(output, 0, depth);

            String combinedNum = Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining());
            setList.add(Integer.valueOf(combinedNum));
        }

        for (int i = 0; i < nums.length; i++) {

            if (!visited[i]) {
                visited[i] = true;
                output[depth] = nums[i];
                permutation(nums, output, visited, depth + 1, r);
                visited[i] = false;
            }
        }
    }

    // 소수확인
    public static boolean isPrimeNum(int num) {

        if (num == 0 || num == 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
