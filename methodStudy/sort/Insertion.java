package sort;

import java.util.Arrays;

public class Insertion {

    public static void main(String[] args) {

        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        for (int i = 1; i < arr.length; i++) {

            int temp = arr[i];

            int beforeIdx = i - 1;

            while (beforeIdx >= 0 && arr[beforeIdx] > temp) {
                arr[beforeIdx + 1] = arr[beforeIdx];
                beforeIdx --;
            }
            arr[beforeIdx + 1] = temp;

            System.out.println(Arrays.toString(arr));
        }
    }
}
