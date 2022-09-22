package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 트리의부모찾기 {

    static int N;
    static int[] parent;
    static List<List<Integer>> graph = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        createAdjacencyList();
        parent = new int[N + 1];
        bfs(1);
        for (int i = 2; i < parent.length; i++) {
            System.out.println(parent[i]);
        }
    }

    public static void createAdjacencyList() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int j = 1; j < N; j++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
    }

    public static void bfs(int node) {
        boolean[] visited =  new boolean[N+1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visited[node] = true;

        while (!q.isEmpty()) {
            Integer poll = q.poll();

            for (Integer temp :graph.get(poll)) {

                if (!visited[temp]) {
                    parent[temp] = poll;
                    q.offer(temp);
                    visited[temp] = true;
                }
            }
        }
    }
}
