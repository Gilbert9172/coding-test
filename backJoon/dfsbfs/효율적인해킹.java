package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 효율적인해킹 {

    static int[] result;
    static int N, M;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[N + 1];

        // 인접 리스트
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }

        for (int j = 1; j <= N; j++) {
            bfs(j);
        }

        StringBuilder sb = new StringBuilder();
        int max = Arrays.stream(result).max().getAsInt();
        for (int i = 1; i < result.length; i++) {
            if (result[i] == max) {
                sb.append(i + " ");
            }
        }
        System.out.println(sb);

    }

    public static void bfs(int x) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        visited[x] = true;

        while (!queue.isEmpty()) {
            Integer temp = queue.poll();
            for (Integer node : graph.get(temp)) {
                if (!visited[node]) {
                    visited[node] = true;
                    queue.offer(node);
                    result[node] ++;
                }
            }
        }
    }
}
