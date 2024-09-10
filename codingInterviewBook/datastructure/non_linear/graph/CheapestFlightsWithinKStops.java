package datastructure.non_linear.graph;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/cheapest-flights-within-k-stops/description/">787. Cheapest Flights Within K Stops</a>
 */
public class CheapestFlightsWithinKStops {

    public int v1(int n, int[][] flights, int src, int dst, int k) {
        //1. graph 생성
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] flight : flights) {
            int idx = flight[0];
            int to = flight[1];
            int price = flight[2];
            graph.get(idx).add(new int[] {to, price});
        }
        //2. 비용이 작은 순으로 우선 순위 큐 생성 (도착지, 비용, 경유 횟수)의 형태
        Queue<Flight> pq = new PriorityQueue<>();
        pq.add(new Flight(src, 0, 0));
        //3. 타임아웃을 방지하게 위해 한 번 방문한 경로는 저장해두는 map 선언
        Map<Integer, Integer> visited = new HashMap<>();
        //4. q가 빌 때 까지 반복
        while (!pq.isEmpty()) {
            Flight flight = pq.poll();
            int node = flight.departure, price = flight.price, viaCount = flight.viaCount;

            if (node == dst) {
                return price;
            }

            visited.put(node, viaCount);
            if (viaCount <= k) {
                viaCount += 1;
                // arrival을 출발지로 하는 경로가 있다면 처리
                for (int[] v : graph.get(node)) {
                    if (!visited.containsKey(v[0]) || viaCount < visited.get(v[0])) {
                        int totalPrice = price + v[1];
                        pq.add(new Flight(v[0], totalPrice, viaCount));
                    }
                }
            }
        }
        return -1;
    }

    public static class Flight implements Comparable<Flight> {
        int departure;
        int price;
        int viaCount;

        public Flight(int departure, int price, int viaCount) {
            this.departure = departure;
            this.price = price;
            this.viaCount = viaCount;
        }

        @Override
        public int compareTo(Flight o) {
            return Integer.compare(this.price, o.price);
        }
    }


    public int v2(int n, int[][] flights, int src, int dst, int k) {
        // 1. graph 생성
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            graph.get(from).add(new int[] {to, price});
        }

        // 2. 결과 배열 1e9로 초기화
        int[] result = new int[n];
        Arrays.fill(result, (int) 1e9);
        result[src] = 0;

        // 3. 우선순위 큐 생성 (경유 횟수, 비용, 현재 노드)
        Queue<FlightV2> pq = new PriorityQueue<>();
        pq.add(new FlightV2(src, 0, 0)); // 출발지, 비용 0, 경유 횟수 0

        // 4. 큐가 빌 때까지 반복
        while (!pq.isEmpty()) {
            FlightV2 flight = pq.poll();
            int node = flight.departure, vc = flight.viaCount, price = flight.price;

            // 경유 횟수가 k를 넘으면 탐색 중단
            if (vc > k) continue;

            // 현재 노드에서 갈 수 있는 모든 경로를 탐색
            for (int[] next : graph.get(node)) {
                int nextNode = next[0];
                int nextPrice = next[1];

                // 더 적은 비용으로 도달할 수 있을 때만 경로를 갱신하고 큐에 추가
                if (result[nextNode] > price + nextPrice) {
                    result[nextNode] = price + nextPrice;
                    pq.add(new FlightV2(nextNode, result[nextNode], vc + 1));
                }
            }
        }

        return result[dst] == (int) 1e9 ? -1 : result[dst];
    }

    public static class FlightV2 implements Comparable<FlightV2> {
        int departure;
        int price;
        int viaCount;

        public FlightV2(int departure, int price, int viaCount) {
            this.departure = departure;
            this.price = price;
            this.viaCount = viaCount;
        }

        @Override
        public int compareTo(FlightV2 o) {
            return Integer.compare(this.viaCount, o.viaCount);
        }
    }
}
