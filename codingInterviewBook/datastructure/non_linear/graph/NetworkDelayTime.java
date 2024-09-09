package datastructure.non_linear.graph;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/network-delay-time/description/">743. Network Delay Time</a>
 */
public class NetworkDelayTime {
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
}
