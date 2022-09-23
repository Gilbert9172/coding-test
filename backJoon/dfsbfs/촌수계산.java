package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 촌수계산 {

    static int N,M,a,b,c,d;
    static int answer = -1;
    static boolean[] visited;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());

        for (int j = 0; j <= N; j++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            c = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            graph.get(c).add(d);
            graph.get(d).add(c);
        }

        visited = new boolean[N + 1];
        dfs(a, 0);
        System.out.println(answer);
    }

    public static void dfs(int a, int count) {
        visited[a] = true;
        for (Integer neighborNode : graph.get(a)) {
            if (!visited[neighborNode]) {
                if (neighborNode == b) {
                    answer = count + 1;
                    return;
                }
                visited[neighborNode] = true;
                dfs(neighborNode, count + 1);
            }
        }
    }
}
