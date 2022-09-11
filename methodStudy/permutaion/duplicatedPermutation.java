package permutaion;

import java.util.Arrays;

// 중복 허용
public class duplicatedPermutation {

    static int[] arr = {1, 2, 3};
    static int[] temp = new int[arr.length];

    public static void main(String[] args) {

        permutation(3, temp, 0);
    }

    public static void permutation(int r, int[] temp, int current) {
        if (r == current) {
            System.out.println(Arrays.toString(temp));
        } else {
            for (int i = 0; i < arr.length; i++) {
                temp[current] = arr[i];
                permutation(r, temp, current + 1);
            }
        }
    }
}
