package level2;

/**
 * 타겟 넘버 (DFS/BFS) - DFS 사용
 */
public class quiz43165 {

    static int[] numbers = {4, 1, 2, 1};
    static int target = 4;
    static int answer = 0;

    public static void main(String[] args) {
        dfs(0, 0);
        System.out.println(answer);
    }

    public static void dfs(int index, int sum) {
        //1. 탈출 조건
        if (index == numbers.length) {
            if (sum == target) answer++;
            return;
        }

        //2. 수행 동작
        dfs(index + 1, sum + numbers[index]);
        dfs(index + 1, sum - numbers[index]);
    }
}