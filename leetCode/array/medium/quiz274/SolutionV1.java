package array.medium.quiz274;

import java.util.Arrays;

// O(nlogn)
public class SolutionV1 {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for (int i = 0; i < citations.length / 2; i++) {
            int temp = citations[citations.length - 1 - i];
            citations[citations.length - 1 - i] = citations[i];
            citations[i] = temp;

        }
        int answer = 0;
        for (int i = 1; i <= citations.length; i++) {
            if (citations[i - 1] >= i) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        int[] citations = {1};

        SolutionV1 solution = new SolutionV1();
        int answer = solution.hIndex(citations);
        System.out.println(answer);
    }

}
