package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 특정거리의도시찾기 {

    static int n,m,k,x;
    static boolean[] visited;
    static Map<Integer, Integer> map = new HashMap<>();
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        generateAdjacencyList();
        generateVisitedArray();
        bfs(x);
        answer();

    }

    private static void generateAdjacencyList() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int j = 0; j <m; j++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }
    }

    private static void generateVisitedArray() {
        visited = new boolean[n + 1];
    }

    private static void bfs(int startNode) {

        Queue<Integer> q = new LinkedList<>();
        q.offer(startNode);
        map.put(startNode, 0);

        while (!q.isEmpty()) {
            Integer temp = q.poll();
            visited[temp] = true;

            for (Integer neighborNode : graph.get(temp)) {
                if (!visited[neighborNode]) {
                    map.put(neighborNode, map.get(temp) + 1);
                    q.offer(neighborNode);
                    visited[neighborNode] = true;
                }
            }
        }
    }

    private static void answer() {
        List<Integer> answerList = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if (map.get(key).equals(k)) {
                answerList.add(key);
            }
        }

        Collections.sort(answerList);
        if (answerList.isEmpty()) {
            System.out.println(-1);
        } else {
            for (Integer integer : answerList) {
                System.out.println(integer);
            }
        }
    }
}
