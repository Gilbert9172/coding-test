package permutaion;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Dfs {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3};
        boolean[] visited = new boolean[arr.length];
        int[] output = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            permutation(arr, output, visited, 0, arr.length, i+1);
        }
//        permutation(arr, output, visited, 0, arr.length, 3);
    }

    public static void permutation(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {

        if (depth == r) {

//            int[] answer = Arrays.copyOfRange(output, 0, depth);

            System.out.println(Arrays.stream(output).mapToObj(String::valueOf).collect(Collectors.joining()));
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                permutation(arr, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }

}
