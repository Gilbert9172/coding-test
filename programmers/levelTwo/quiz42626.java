package levelTwo;

import java.util.PriorityQueue;

/**
 * <h3>더 맴게</h3>
 * <br>
 * 문제번호 - 42626번<br>
 * 난이도 - Lv2<br>
 * 시간 복잡도 - nlogN<br>
 */
public class quiz42626 {

    public static void main(String[] args) {

        int[] scoville = {1, 2, 3, 9, 10, 12};
        int k = 7;
        System.out.println(Solution.solution(scoville,k));
    }

    static class Solution {


       static int solution(int[] scoville, int K) {

           int answer = 0;

           PriorityQueue<Integer> heap = new PriorityQueue<>();

           for (int s : scoville) {
               heap.offer(s);
           }

           while (heap.peek() < K) {

               if (heap.size() == 1) return -1;

               int a = heap.poll();
               int b = heap.poll();

               int newFood = a + (b * 2);

               heap.offer(newFood);
               answer ++;
           }


           return answer;
       }

    }

}
