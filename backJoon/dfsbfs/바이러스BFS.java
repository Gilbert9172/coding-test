package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 바이러스BFS {

    static int n, m, answer;
    static int[][] graph;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt( br.readLine());
        m = Integer.parseInt( br.readLine());

        graph = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = graph[b][a] = 1;
        }

        boolean[] visited = new boolean[n+1];
        bfs(1, visited);
        System.out.println(answer);

    }

    public static void bfs(int node, boolean[] visited) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {

            Integer temp = queue.poll();
            visited[temp] = true;

            for (int i = 1; i <= n; i++) {
                if (!visited[i] && graph[temp][i] == 1) {
                    visited[i] = true;
                    queue.offer(i);
                    answer ++;
                }
            }
        }
    }
}
