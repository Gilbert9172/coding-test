package datastructure.non_linear.graph;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/network-delay-time/description/">743. Network Delay Time</a>
 */
public class NetworkDelayTime {

    // 배열 내에서 선형탐색을 하고, 중복된 정점을 허용하지 않는 방식
    public int v1(int[][] times, int n, int k) {
        //1. 네트워크의 각 노드를 <출발지, <도착지, 소요시간>> 형태의 그래프로 구성
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] time : times) {
            int departure = time[0];
            int arrival = time[1];
            int wasteTime = time[2];
            graph.putIfAbsent(departure, new HashMap<>());
            graph.get(departure).put(arrival, wasteTime);
        }
        //2. 우선 순위 큐 생성. (도착지, 소요시간)의 형태
        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
        pq.add(new AbstractMap.SimpleEntry<>(k, 0));
        //3. (도착지, 소요시간) 형태의 최종 결과를 저장하는 변수 선언
        Map<Integer, Integer> result = new HashMap<>();
        //4. 큐에 값이 없을 때 까지 반복
        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> shortestTime = pq.poll();
            int arrival = shortestTime.getKey();
            int wasteTime = shortestTime.getValue();
            if (!result.containsKey(arrival)) {
                result.put(arrival, wasteTime);
                if (graph.containsKey(arrival)) {
                    for (Map.Entry<Integer, Integer> entry : graph.get(arrival).entrySet()) {
                        int totalWasteTime = wasteTime + entry.getValue();
                        pq.add(new AbstractMap.SimpleEntry<>(entry.getKey(), totalWasteTime));
                    }
                }
            }
        }
        return result.size() != n ? -1 : Collections.max(result.values());
    }

    // 우선순위큐 내에서 최솟값 탐색 + 우선순위큐 내에 중복 정점 허용
    public int v2(int[][] times, int n, int k) {
        //1. graph 생성 : 네트워크의 각 노드를 인덱스로하는 List<List<int[]>> 배열 생성
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] time : times) {
            int departure = time[0];
            int arrival = time[1];
            int wasteTime = time[2];
            graph.get(departure).add(new int[] {arrival, wasteTime});
        }
        //2. 결과 배열을 1e9로 초기화
        int[] result = new int[n + 1];
        Arrays.fill(result, (int) 1e9);
        result[k] = 0;

        //3. 우선 순위 큐 생성. (도착지, 소요시간)의 형태
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(w -> w[1]));
        pq.add(new int[]{k, 0});

        //4. 큐에 값이 없을 때 까지 반복
        while (!pq.isEmpty()) {
            int[] shortest = pq.poll();
            int departure = shortest[0], time = shortest[1];
            if (graph.get(departure) != Collections.EMPTY_LIST) {
                for (int[] node : graph.get(departure)) {
                    int from = node[0], nTime = node[1];
                    if (time + nTime < result[from]) {
                        result[from] = time + nTime;
                        pq.add(new int[]{from, result[from]});
                    }
                }
            }
        }
        int minTime = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            minTime = Math.max(minTime, result[i]);
        }
        return minTime == (int) 1e9 ? -1 : minTime;
    }

    // 우선순위큐 내에서 최솟값 탐색 + 우선순위큐 내에 중복 정점 허용하지 않음
    public int v3(int[][] times, int n, int k) {
        // 1. 그래프 생성 (인접 리스트)
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] time : times) {
            int departure = time[0];
            int arrival = time[1];
            int wasteTime = time[2];
            graph.get(departure).add(new int[] {arrival, wasteTime});
        }

        // 2. 결과 배열을 1e9로 초기화
        int[] result = new int[n + 1];
        Arrays.fill(result, (int) 1e9);
        result[k] = 0;

        // 3. 방문 체크 배열
        boolean[] visited = new boolean[n + 1];

        // 4. 우선순위 큐 생성 (도착지, 소요시간)의 형태
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(w -> w[1]));
        pq.add(new int[]{k, 0});

        // 5. 큐에 값이 없을 때까지 반복
        while (!pq.isEmpty()) {
            int[] shortest = pq.poll();
            int node = shortest[0];
            int time = shortest[1];

            // 이미 방문한 노드는 스킵
            if (visited[node]) continue;

            // 현재 노드를 방문 처리
            visited[node] = true;

            // 현재 노드에서 연결된 이웃 노드들에 대해 탐색
            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                int travelTime = neighbor[1];

                // 더 짧은 경로가 있다면 업데이트하고 큐에 추가 (중복 없이)
                if (!visited[nextNode] && time + travelTime < result[nextNode]) {
                    result[nextNode] = time + travelTime;
                    pq.add(new int[]{nextNode, result[nextNode]});
                }
            }
        }

        // 6. 결과 값 계산
        int minTime = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (result[i] == (int) 1e9) return -1; // 도달 불가능한 노드가 있으면 -1 반환
            minTime = Math.max(minTime, result[i]);
        }

        return minTime;
    }
}
