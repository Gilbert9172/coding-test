package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연결요소의수 {

    static int n, m, a, b, answer;
    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n+1][n+1];
        visited = new boolean[n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            graph[a][b] = graph[b][a] = 1;
        }

        for (int j = 1; j <= n; j++) {
            if (!visited[j]) {
                dfs(j);
                answer ++;
            }
        }
        System.out.println(answer);
    }

    private static void dfs(int node) {

        visited[node] = true;

        int[] neighborNodes = graph[node];

        for (int i = 0; i < neighborNodes.length; i++) {
            if (!visited[i] && neighborNodes[i] == 1) {
                dfs(i);
            }
        }
    }
}
