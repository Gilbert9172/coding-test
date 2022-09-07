package permutaion;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Swap {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3};
        permutation(arr, 0, 3, 3);

    }

    public static void permutation(int[] arr, int depth, int n, int r) {
        if (depth == r) {
            String joiningElements = Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining());
            System.out.println(joiningElements);

        }

        for (int i = depth; i < n; i++) {
            // arr[depth] ←→ arr[i]
            swap(arr, depth, i);

            // 한 단계 더 들어가서 스왑
            permutation(arr, depth + 1, n, r);

            // 탈출 조건 만족시 배열 원상복귀
            swap(arr, depth, i);
        }
    }

    public static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }



}
