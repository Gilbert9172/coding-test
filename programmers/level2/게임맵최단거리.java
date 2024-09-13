package level2;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {

    static int maxRow;
    static int maxCol;
    static int answer;
    static int[][] move = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited;

    public static void main(String[] args) {

        //TEST CASE - 1
        int[][] maps = new int[][]{
                    {1, 0, 1, 1, 1},
                    {1, 0, 1, 0, 1},
                    {1, 0, 1, 1, 1},
                    {1, 1, 1, 0, 1},
                    {0, 0, 0, 0, 1}};

        /*TEST CASE - 2
        int[][] maps = new int[][]{
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1}};
         */

        maxRow = maps.length;
        maxCol = maps[0].length;
        visited = new boolean[maxRow][maxCol];
        bfs(0, 0, maps);
        System.out.println(answer);
    }

    public static void bfs(int x, int y, int[][] maps) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {

            int[] current = queue.poll();
            int curX = current[0];
            int curY = current[1];

            visited[curX][curY] = true;

            for (int i = 0; i < move.length; i++) {
                int newX = curX + move[i][0];
                int newY = curY + move[i][1];

                if (isInRange(newX, newY, maps)) {
                    queue.offer(new int[]{newX, newY});
                    visited[newX][newY] = true;
                    maps[newX][newY] = maps[curX][curY] + 1;

                    if (visited[maxRow - 1][maxCol - 1]) {
                        answer = maps[newX][newY];
                        return;
                    }

                }
            }
        }
        answer = -1;
    }

    public static boolean isInRange(int newX, int newY, int[][] maps) {

        if (newX >= 0 && newX < maxRow && newY >= 0 && newY < maxCol && maps[newX][newY] != 0 && !visited[newX][newY]) {
            return true;
        }
        return false;
    }

}
