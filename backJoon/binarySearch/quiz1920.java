package binarySearch;

import java.util.Arrays;
import java.util.Scanner;

/**************************************
 * 백준
 * 수찾기 (실버4)
 **************************************
 * 사용된 알고리즘 - 이분탐색
 **************************************/
public class quiz1920 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = in.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);

        int M = in.nextInt();
        for(int i = 0; i < M; i++) {
            if(binarySearch(arr, in.nextInt()) >= 0) {
                sb.append(1 + "\n");
            }
            else {
                sb.append(0 + "\n");
            }
        }
        System.out.println(sb);

    }

    public static int binarySearch(int[] arr,int target) {

        //1. 시작과 끝의 인덱스
        int startPoint = 0;
        int endPoint = arr.length - 1;

        while (startPoint <= endPoint) {

            //2. 중간 지점
            int midPoint = (startPoint + endPoint) / 2;

            //3. target < mid
            if (target < arr[midPoint]) {
                endPoint = midPoint - 1;
            }

            //4. target > mid
            else if (target > arr[midPoint]) {
                startPoint = midPoint + 1;
            }

            //5. target == midPoint
            else {
                return midPoint;
            }
        }
        return -1;
    }
}
