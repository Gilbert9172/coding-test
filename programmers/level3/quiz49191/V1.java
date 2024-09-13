package level3.quiz49191;

import java.util.*;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/49191">순위</a>
 */
public class V1 {
    public int solution(int n, int[][] results) {
        // 그래프 초기화 (n+1 크기, 1-based 인덱스 사용)
        int[][] graph = new int[n + 1][n + 1];

        // 경기 결과 반영
        for (int[] result : results) {
            graph[result[0]][result[1]] = 1; // 이겼을 때 1
            graph[result[1]][result[0]] = -1; // 졌을 때 -1
        }

        // 플로이드-워셜 알고리즘 수행
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                        graph[j][i] = -1;
                    }
                    if (graph[i][k] == -1 && graph[k][j] == -1) {
                        graph[i][j] = -1;
                        graph[j][i] = 1;
                    }
                }
            }
        }

        // 순위를 확정할 수 있는 플레이어의 수 계산
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] != 0) count++;
            }
            if (count == n - 1) answer++;
        }

        return answer;
    }
}
