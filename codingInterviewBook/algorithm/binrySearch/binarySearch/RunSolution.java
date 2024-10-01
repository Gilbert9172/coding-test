package algorithm.binrySearch.binarySearch;

public class RunSolution {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12, 15};
        V1 v1 = new V1();
        int answer = v1.search(nums, 2);
        System.out.println(answer);

        V2 v2 = new V2();
        int answer2 = v2.search(nums, 9);
        System.out.println(answer2);

        int start = Integer.MAX_VALUE;
        int end = Integer.MAX_VALUE;
        int mid = start + (start - end) / 2;
        System.out.println(mid);
    }
}
