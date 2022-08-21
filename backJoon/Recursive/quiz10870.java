package Recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 피보나치5 (10870)
 */
public class quiz10870 {

    static Integer count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());

        System.out.println(fibonacci(0,1, N));
    }

    public static Integer fibonacci(Integer a, Integer b, Integer N) {

        // 탈출 조건1
        if (N <= 1 ) {
            return N;
        }

        // 수행 동작
        count ++;
        Integer sum = a + b;

        // 탈출 조건2
        if (count.equals(N - 1)) {
            return sum;
        }
        return fibonacci(b, sum, N);
    }

//    static int fibonacci(int N) {
//        if (N == 0)	return 0;
//        if (N == 1)	return 1;
//        return fibonacci(N - 1) + fibonacci(N - 2);
//    }

}