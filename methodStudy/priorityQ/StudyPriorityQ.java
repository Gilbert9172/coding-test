package priorityQ;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class StudyPriorityQ {

    public static void main(String[] args) {

        int[] arr = {3,7,8,1,20};

//        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Comparator<Integer> comparator = (o1, o2) -> o2 - o1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(comparator);


        for (int i : arr) {
            pq.offer(i);
        }

        System.out.println(pq.poll());

    }

}
