package binarySearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**************************************
 * 숫자 카드 2
 * 실버4
 **************************************
 * 사용된 알고리즘 - 이분탐색
 **************************************/
public class quiz10816 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = in.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {arr[i] = in.nextInt();}
        Arrays.sort(arr);

        Map<Integer, Integer> inputHash = new HashMap<>();
        for (int i : arr) {
            int hashVal = inputHash.getOrDefault(i, 0);
            if (hashVal == 0) {
                inputHash.put(i, 1);
            } else {
                inputHash.put(i, inputHash.get(i)+1);
            }
        }

        int M = in.nextInt();
        for(int i = 0; i < M; i++) {
            int target = in.nextInt();
            if (binarySearch(arr, target) == "Finish" ) {
                sb.append(inputHash.get(target) + " ");
            } else {
                sb.append(inputHash.getOrDefault(target,0) + " ");
            }
        }
        System.out.println(sb);
    }

    public static String binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high)/2;

            if (target > arr[mid]) {low = mid + 1;}
            else if (target < arr[mid]) {high = mid -1;}
            else {return "Finish";}
        }
        return "notFound";
    }
}