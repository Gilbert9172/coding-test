package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 백준 2667
 * 단지번호 붙이기(실버1)
 */

public class quiz2667 {

    static int n;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited;
    static int aptBlocks;           //동

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");
            List<Integer> inputList = Arrays.stream(str).map((a) -> Integer.parseInt(a)).collect(Collectors.toList());
            graph.add((ArrayList<Integer>) inputList);
        }
        visited = new boolean[n][n];

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                // 한 번도 방문하지 않았고, 해당 좌표가 1이라면
                int node = graph.get(i).get(j);
                if (!visited[i][j] && node == 1) {
                    aptBlocks = 0;
                    dfs(i, j);
                    result.add(aptBlocks);
                }
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    public static void dfs(int row, int col) {

        // 1. 방문처리
        aptBlocks++;
        visited[row][col] = true;

        // 2. 상하좌우 이동하면서 이웃된 집을 찾는다.
        for (int i = 0; i < move.length; i++) {
            // 상,하로 이동할 경우에는 새로운 행 : newRow
            // 좌,우로 이동할 경우에는 새로운 열 : newCol
            int newRow = row + move[i][0];
            int newCol = col + move[i][1];

            /**
             * 3. 이동하기 위한 조건
             *
             * 3-1. 주어진 범위에서 벗어나선 안된다.
             *      ㄴ (newRow >= 0 && newRow < 7 && newCol >= 0 && newCol < 7)
             *
             * 3-2. 단 한 번도 방문한 적이 없어야 한다.
             *      ㄴ (!visited[newRow][newCol])
             *
             * 3-3. 연결된 집이여야 한다.(대가선은 안됨)
             *      ㄴ (graph.get(newRow).get(newCol) == 1)
             */
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n
                    && !visited[newRow][newCol] && graph.get(newRow).get(newCol) == 1) {
                dfs(newRow, newCol);
            }
        }
    }
}
