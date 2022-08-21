package Recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 팩토리얼(10872)
 */
public class quiz10872 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long N = Long.valueOf(br.readLine());

        Long answer = factorial(N);
        System.out.println(answer);
    }


    public static Long factorial(Long num) {

        // 탈출 조건
        if (num <= 1) {
            return 1L;
        }

        // 수행동작
        return num * factorial(num - 1);
    }
}

/*
6*factorial(5) {
    5 * factorial(4) {
        4 * factorial(3) {
            3 * factorial(2) {
                2 * factorial(1) {
                    return 1;
                }
                return 2 * 1;
            }
            return 3 * 2 * 1;
        }
        return 4 * 3 * 2 * 1;
    }
    return 5 * 4 * 3 * 2 * 1;
}
return 6 * 5 * 4 * 3 * 2 * 1;
 */
