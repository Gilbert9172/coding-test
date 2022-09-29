package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class 영역구하기DFS2583 {

    static int M,N,K;
    static int x1,y1,x2,y2, count;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static List<Integer> areaList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        generateMatrixAndVisited();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Position pos = new Position(i,j);
                if (isNeverVisited(pos)) {
                    count = 0;
                    addAreaToList(pos);
                }
            }
        }
        Collections.sort(areaList);
        printAnswer();
    }

    private static class Position {

        private int row;
        private int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return this.row;
        }

        public int getCol() {
            return this.col;
        }
    }

    private static boolean isNeverVisited(Position position) {
        return !visited[position.getRow()][position.getCol()] && graph[position.getRow()][position.getCol()] == 0;
    }

    private static void addAreaToList(Position position) {
        int area = dfs(position);
        areaList.add(area);
    }

    private static void generateMatrixAndVisited() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());


            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    graph[x][y] = 1;
                }
            }
        }
    }

    private static int dfs(Position pos) {

        visited[pos.getRow()][pos.getCol()] = true;
        count++;

        for (int i = 0; i < dx.length; i++) {
            int nextRow = pos.getRow() + dx[i];
            int nextCol = pos.getCol() + dy[i];

            Position nextPos = new Position(nextRow, nextCol);

            if (isInRange(nextPos)) {
                dfs(nextPos);
            }
        }
        return count;
    }

    private static boolean isInRange(Position nextPos) {
        if (nextPos.getRow() >= 0 && nextPos.getRow() < N && nextPos.getCol() >= 0 && nextPos.getCol() < M
                && !visited[nextPos.getRow()][nextPos.getCol()] && graph[nextPos.getRow()][nextPos.getCol()] == 0) {
            return true;
        }
        return false;
    }

    private static void printAnswer() {
        System.out.println(areaList.size());
        System.out.println(areaList.stream().map(i -> String.valueOf(i)).collect(Collectors.joining(" ")));
    }
}
