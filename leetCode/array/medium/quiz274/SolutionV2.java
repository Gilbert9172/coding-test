package array.medium.quiz274;


public class SolutionV2 {

    public int hIndex(int[] citations) {

        int n = citations.length;
        int[] count = new int[n + 1];

        for (int citation : citations) {
            if (citation >= n) {
                count[n]++;
            } else {
                count[citation]++;
            }
        }

        int hIndex = 0;
        for (int i = n; i >= 0; i--) {
            hIndex += count[i];
            if (hIndex >= i) {
                return i;
            }
        }
        
        return 0;
    }

    public static void main(String[] args) {

        int[] citations = {3, 0, 6, 1, 5};

        SolutionV2 solution = new SolutionV2();
        int answer = solution.hIndex(citations);
        System.out.println(answer);
    }
}
