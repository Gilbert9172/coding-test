package dfs.medium.quiz2101;

public class SolutionV1 {

    public int maximumDetonation(int[][] bombs) {
        int maxBomb = 0;
        for (int i = 0; i < bombs.length; i++) {
            int detonatedBombCount = getMaxDFS(i, bombs, new boolean[bombs.length]);
            maxBomb = Math.max(maxBomb, detonatedBombCount);
        }
        return maxBomb;
    }

    private int getMaxDFS(int index, int[][] bombs, boolean[] seen) {
        int count = 1;
        seen[index] = true;

        for (int i = 0; i < bombs.length; i++) {
            if (!seen[i] && isInRange(bombs[index], bombs[i])) {
                count += getMaxDFS(i, bombs, seen);
            }
        }

        return count;
    }

    private boolean isInRange(int[] point1, int[] point2) {
        long dx = point1[0] - point2[0], dy = point1[1] - point2[1], radius = point1[2];
        long distance = dx * dx + dy * dy;
        return distance <= radius * radius;
    }

    public static void main(String[] args) {
        int[][] bombs = {{2, 1, 3}, {6, 1, 4}};
        SolutionV1 solution = new SolutionV1();
        int answer = solution.maximumDetonation(bombs);
        System.out.println(answer);
    }
}
