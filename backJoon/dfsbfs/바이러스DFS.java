package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 바이러스DFS {

    static int n,m,answer;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt( br.readLine());
        m = Integer.parseInt( br.readLine());

        for (int j = 0; j <= n; j++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        boolean[] visited = new boolean[n+1];
        dfs(1, visited);
        System.out.println(answer);
    }

    public static void dfs(int node, boolean[] visited) {

        visited[node] = true;
        List<Integer> neighborNodes = graph.get(node);

        for (Integer neighborNode : neighborNodes) {
            if (!visited[neighborNode]) {
                dfs(neighborNode, visited);
            }
        }
        if (node != 1) answer ++;
    }
}
