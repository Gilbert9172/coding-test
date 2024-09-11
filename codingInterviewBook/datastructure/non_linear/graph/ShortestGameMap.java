package datastructure.non_linear.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/1844?language=java">게임 맵 최단거리</a>
 */
public class ShortestGameMap {
    private final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int maxCol, maxRow;
    private boolean[][] visited;

    public int solution(int[][] maps) {
        maxRow = maps.length;
        maxCol = maps[0].length;
        visited = new boolean[maxRow][maxCol];
        bfs(maps);
        boolean visitedLastPosition = visited[maxRow - 1][maxCol - 1];
        return visitedLastPosition ? maps[maxRow-1][maxCol-1] : -1;
    }

    public void bfs(int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int curRow = curr[0];
            int curCol = curr[1];

            for (int[] dir : dirs) {
                int nRow = curRow + dir[0];
                int nCol = curCol + dir[1];

                if (isInRange(maps, nRow, nCol)) {
                    visited[nRow][nCol] = true;
                    maps[nRow][nCol] = maps[curRow][curCol] + 1;
                    q.offer(new int[]{nRow, nCol});
                }
            }
        }
    }

    private boolean isInRange(int[][] maps, int nRow, int nCol) {
        return nRow >= 0 && nRow < maxRow && nCol >= 0 && nCol < maxCol &&
                !visited[nRow][nCol] && maps[nRow][nCol] != 0;
    }
}
