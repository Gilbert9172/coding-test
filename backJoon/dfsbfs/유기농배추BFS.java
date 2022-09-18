package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 유기농배추BFS {

    static int n, a, b, c;
    static List<Integer> answer = new ArrayList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static boolean[][] visited;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            graph = new int[a][b];

            c = Integer.parseInt(st.nextToken());
            for (int j = 0; j < c; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[x][y] = 1;
            }

            visited = new boolean[a][b];

            int temp = 0;
            for (int l = 0; l < a; l++) {
                for (int k = 0; k < b; k++) {
                    if (graph[l][k] == 1 && !visited[l][k]) {
                        temp++;
                        bfs(l,k);
                    }
                }
            }
            answer.add(temp);
        }

        for (Integer integer : answer) {
            System.out.println(integer);
        }
    }

    private static void bfs(int row, int col) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});

        while (!queue.isEmpty()) {

            int[] current = queue.poll();
            int curRow = current[0];
            int curCol = current[1];
            visited[curRow][curCol] = true;

            for (int i = 0; i < dx.length; i++) {
                int newRow = curRow + dx[i];
                int newCol = curCol + dy[i];

                if (isInRange(newRow, newCol)) {
                    visited[newRow][newCol] = true;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
    }

    private static boolean isInRange(int newRow, int newCol) {
        if (newRow >= 0 && newRow < a && newCol >= 0 && newCol < b
                && !visited[newRow][newCol] && graph[newRow][newCol] == 1) {
            return true;
        }
        return false;
    }
}
