package algorithm.binrySearch.searchInRotatedSortedArray;

public class RunSolve {
    public static void main(String[] args) {
        V2 solution = new V2();
        int[] nums = {4, 5, 6, 7, 0, 1, 2, 3};
        int answer = solution.search(nums, 2);
        System.out.println(answer);
    }
}
