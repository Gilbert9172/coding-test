package level1;

/**
 * 완전탐색
 * 최소직사각형
 * https://school.programmers.co.kr/learn/courses/30/lessons/86491
 */

/**
 * 로직
 * 1. 가로 < 세로 의 경우 위치를 바꾼다.
 * 2. 가로 중에 가장 큰 수, 세로 중에 가장 큰 수를 찾는다.
 * 3. 둘이 곱한다.
 */

import java.util.ArrayList;
import java.util.Collections;

public class quiz86491 {

    static ArrayList<Integer> widths = new ArrayList<>();
    static ArrayList<Integer> lengths = new ArrayList<>();

    public static void main(String[] args) {
        int[][] sizes = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
        System.out.println(Solution1.solution(sizes));
        System.out.println(Solution2.solution(sizes));
    }

    static class Solution1 {

        static int solution(int[][] sizes) {

            for (int[] cardSize : sizes) {
                int width = cardSize[0];
                int length = cardSize[1];
                if (width < length) {
                    switchPosition(cardSize);
                } else {
                    stayPosition(cardSize);
                }
            }
            return perfectSize();
        }

        // 가로, 세로 변경
        public static void switchPosition(int[] cardSize) {
            widths.add(cardSize[1]);
            lengths.add(cardSize[0]);
        }

        // 가로, 세로 유지
        public static void stayPosition(int[] cardSize) {
            widths.add(cardSize[0]);
            lengths.add(cardSize[1]);
        }

        // 결과
        public static Integer perfectSize() {
            int maxWidth = Collections.max(widths);
            int maxLength = Collections.max(lengths);
            return maxWidth * maxLength;
        }

    }

    // Math를 활용한 풀이
    static class Solution2 {
        static int solution(int[][] sizes) {

            int minSide = 0;
            int maxSide = 0;

            for (int[] size : sizes) {
                int min = Math.min(size[0], size[1]);
                int max = Math.max(size[0], size[1]);

                minSide = Math.max(min, minSide);
                maxSide = Math.max(max, maxSide);
            }
            return minSide*maxSide;
        }
    }

}