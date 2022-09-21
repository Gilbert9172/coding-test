package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 효율적인해킹 {

    static int[] count;
    static int N, M;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        // ⒈ 인접리스트를 생성한다.
        createAdjacencyList();

        // ⒉ 노드 방문 횟수를 저장하기 위한 count 배열을 생성한다.
        count = new int[N + 1];

        // ⒊ 노드의 갯수를 범위로 하는 반복문을 작성한다.
        for (int j = 1; j <= N; j++) {

            // ⒋ 반복문을 순회하면서 BFS로직을 실행한다.
            bfs(j);
        }

        // ⒍ 가장 많이 방문한 노드를 반환한다.
        StringBuilder result = NumberOfComputer();
        System.out.println(result);
    }

    public static void createAdjacencyList() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }
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

                    // ⒌ BFS 로직을 돌면서 노드에 방문할 때 마다, 해당 노드의 방문 횟수를 1 증가한다.
                    count[node] ++;
                }
            }
        }
    }

    public static StringBuilder NumberOfComputer() {
        StringBuilder sb = new StringBuilder();
        int max = Arrays.stream(count).max().getAsInt();
        for (int i = 1; i < count.length; i++) {
            if (count[i] == max) {
                sb.append(i + " ");
            }
        }
        return sb;
    }
}
