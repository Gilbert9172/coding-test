package sort;

import java.util.Arrays;

public class Quick {

    public static void main(String[] args) {
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int first, int last) {
        if (first >= last) return;      // 첫 번째 인덱스가 마지막 인덱스를 넘을 때?

        int pivot = first;
        int i = first + 1;
        int j = last;
        System.out.println("피봇 = " + arr[pivot]);

        while (i <= j) {
            while(i <= last && arr[i] <= arr[pivot]) i++;
            while (j > first && arr[j] >= arr[pivot]) j--;
                if (i > j) swap(arr, pivot, j);
                else swap(arr, i, j);
            System.out.println("중간 점검 = " + Arrays.toString(arr));
        }

        System.out.println("결과 = " + Arrays.toString(arr));
        quickSort(arr, first, j - 1);
        quickSort(arr, j + 1, last);
    }


    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
