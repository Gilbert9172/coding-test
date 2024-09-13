package level2;

import java.util.*;

/**
 * 기능개발
 */
public class quiz42586 {

    static int complete = 100;
    static List<Integer> temp = new ArrayList<>();

    public static void main(String[] args) {

        // TEST_CASE
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        //1. 각 작업이 완료(100)될 때 까지 걸리는 시간 구하기.
        Queue<Integer> q1 = processCompleteTimeTakenQueue(progresses, speeds);

        // 2. 핵심로직 : 두 개의 큐의 첫번째 요소 값을 비교후 결과 도출
        compareTwoQueue(q1);

        // 3. ArrayList → int[]
        int[] answer = arrayListToIntArray();

        // 4. 출력
        Arrays.stream(answer).forEach(System.out::println);
    }


    public static Queue<Integer> processCompleteTimeTakenQueue(int[] progresses, int[] speeds) {

        Queue<Integer> q1 = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int datesRequiredToComplete = (complete - progresses[i]) / speeds[i];

            if ((complete - progresses[i]) % speeds[i] > 0) {
                datesRequiredToComplete += 1;
            }
            q1.offer(datesRequiredToComplete);
        }
        return q1;
    }


    public static void compareTwoQueue(Queue<Integer> q1) {
        Integer firstVal = q1.poll();
        Queue<Integer> q2 = new LinkedList<>();
        q2.offer(firstVal);

        while (!q1.isEmpty()) {

            Integer firstValOfQ1 = q1.element();
            Integer firstValOfQ2 = q2.element();

            if (firstValOfQ2 >= firstValOfQ1) {
                q2.offer(q1.poll());
            } else if (firstValOfQ2 < firstValOfQ1) {
                temp.add(q2.size());
                q2.clear();
                q2.offer(q1.poll());
            }
        }
        temp.add(q2.size());
    }

    public static int[] arrayListToIntArray() {
        return temp.stream().mapToInt(Integer::intValue).toArray();
    }
}
