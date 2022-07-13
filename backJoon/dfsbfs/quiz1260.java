package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 난이도 : 실버2
 * DFS와 BFS
 */

public class quiz1260 {

    static int n,m;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static StringBuilder sb2 = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());

        //간선의 개수
        m = Integer.parseInt(st.nextToken());

        //처음 노드
        int r =Integer.parseInt(st.nextToken());

        // 방문확인 배열 초기화
        int[] checkVisited = new int[n+1];

        initializeGraph(br, st);
        sortGraph();

        System.out.println(dfs(r, checkVisited));
        System.out.println(bfs(r, graph, checkVisited));

    }

    // 각각의 연결된 노드 리스트를 오름차순으로 재배열
    public static void sortGraph() {
        for(int i = 0; i < graph.size(); i++){
            Collections.sort(graph.get(i));
        }
    }

    // Graph 초기화
    public static void initializeGraph (BufferedReader br, StringTokenizer st) throws IOException {
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int j = 0; j < m; j++ ) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
    }


    // DFS
    public static String dfs(int node, int[] checkVisited) {
        // 1. 시작점 방문처리
        checkVisited[node] = 1;
        sb.append(node + " ");

        // 2. 인접한 노드 찾기
        ArrayList<Integer> linkedNodes = graph.get(node);

        // 3. 인접한 노드 중 아직 방문하지 않은 노드 확인.
        for (Integer linkedNode : linkedNodes) {
            if (checkVisited[linkedNode] == 0) {
                dfs(linkedNode, checkVisited);
            }
        }
        return sb.toString();
    }


    // BFS
    public static String bfs(int node, ArrayList<ArrayList<Integer>> graph, int[] checkVisited) {
        // 1. Queue 생성
        Queue<Integer> q = new LinkedList<>();

        // 2. 시작 노드 Queue에 넣은 후 방문처리.
        q.offer(node);
        checkVisited[node] = 0;

        // 3. while문 돌면서 방문하지 않은 노드 확인.
        while (!q.isEmpty()) {
            int mainNode = q.poll();
            sb2.append(mainNode + " ");

            // 3-1. 인접한 노드 찾기
            ArrayList<Integer> linkedNodes = graph.get(mainNode);

            for (Integer linkedNode : linkedNodes) {
                // 3-2. 아직 방문하지 않았다면 방문 처리 후 Queue에 offer
                if (checkVisited[linkedNode] == 1) {
                    checkVisited[linkedNode] = 0;
                    q.offer(linkedNode);
                }
            }
        }
        return sb2.toString();
    }
}
