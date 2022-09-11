package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 미로 탐색 (실버1)
 * https://www.acmicpc.net/problem/2178
 */
public class 미로탐색 {

    static int n;
    static int m;
    static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean[][] visited;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");
            List<Integer> inputList = Arrays.stream(str).map(Integer::parseInt).collect(Collectors.toList());
            graph.add(inputList);
        }

        visited = new boolean[n][m];
        bfs(0,0);
        System.out.println(graph.get(n-1).get(m-1));
    }

    public static void bfs(int row, int col) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curRow = current[0];
            int curCol = current[1];
            visited[curRow][curCol] = true;

            // 이동 하기.
            for (int i = 0; i < move.length; i++) {
                int newRow = curRow + move[i][0];
                int newCol = curCol + move[i][1];

                // 이동가능한 범위 내에 있을 경우
                if (isInRange(newRow, newCol)) {

                    // 다음 위치를 큐에 넣는다.
                    queue.offer(new int[]{newRow, newCol});

                    // 방문등록
                    visited[newRow][newCol] = true;

                    // 몇번 째 이동칸인지 확인하기 위하여 +1
                    graph.get(newRow).set(newCol, graph.get(curRow).get(curCol) + 1);

                    // 마지막 노드에 도착했을 경우 탈출.
                    if(visited[n-1][m-1]) {
                        return;
                    }
                }
            }

        }
    }

    public static boolean isInRange(int newRow, int newCol) {
        if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m
                && !visited[newRow][newCol] && graph.get(newRow).get(newCol) == 1) {
            return true;
        }
        return false;
    }
}