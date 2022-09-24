package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 그림 {

    static int n,m;
    static List<Integer> picSizeList = new ArrayList<>();
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        generateAdjacencyMatrix();
        generateVisitedArray();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    int picSize = bfs(i, j);
                    picSizeList.add(picSize);
                }
            }
        }

        if (picSizeList.isEmpty()) {
            System.out.println(0+"\n"+0);
        } else {
            System.out.println(picSizeList.size() +"\n"+ Collections.max(picSizeList));
        }
    }

    private static void generateAdjacencyMatrix() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];

        /** 메모리 많이 사용하는 코드
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(str[j]);
            }
        }
        */

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0, idx = 0; j < m; j++, idx+=2) {
                graph[i][j] = line.charAt(idx) - '0';
            }
        }
    }

    private static void generateVisitedArray() {
        visited = new boolean[n][m];
    }

    private static int bfs(int row, int col) {

        int count = 1;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});
        visited[row][col] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int curRow = current[0];
            int curCol = current[1];

            for (int i = 0; i < dx.length; i++) {
                int nextRow = curRow + dx[i];
                int nextCol = curCol + dy[i];

                if (isInRange(nextRow, nextCol)) {
                    visited[nextRow][nextCol] = true;
                    count ++;
                    q.offer(new int[]{nextRow, nextCol});
                }
            }
        }
        return count;
    }

    private static boolean isInRange(int nextRow, int nextCol) {
        if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m
                && !visited[nextRow][nextCol] && graph[nextRow][nextCol] == 1) {
            return true;
        }
        return false;
    }
}
