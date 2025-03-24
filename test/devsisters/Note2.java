package devsisters;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Note2 {
    public static void main(String[] args) {
        int[][] routes = {{5, 1, 15}, {14, 3, 18}, {3, 15, 21}, {9, 14, 52}};
//        int[][] routes = {{3, 12, 16}, {8, 2, 12}, {1, 14, 15}};
        Note2 note = new Note2();
        boolean solution = note.solution(8, routes);
        System.out.println(solution);

    }

    public boolean solution(int capacity, int[][] routes) {

        // routes 정렬 (pick up 위치 기준 오름차순)
        // [5,1,4], [3,2,6], [1,7,13]
        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));

        // PQ 생성 (drop 위치 기준 오름차순)
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                Comparator.comparingInt(a -> a[2])
        );

        int currentCapa = 0;
        for (int[] route : routes) {

            int giftNum = route[0];
            int from = route[1];
            int to = route[2];

            while (!pq.isEmpty() && pq.peek()[2] <= from) {
                int[] poll = pq.poll();
                currentCapa -= poll[0];
            }

            currentCapa += giftNum;
            if (currentCapa > capacity) return false;
            pq.offer(route);
        }
        return true;
    }
}
