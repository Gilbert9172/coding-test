package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질 {

    static int n,m;
    static int[] check = new int[100001];

    public static void main(String[] args) throws IOException {

        generateAdjacencyList();

        if (n == m) {
            System.out.println(0);
        } else {
            bfs(n,m);
        }
    }

    private static void generateAdjacencyList() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

    }

    private static void bfs(int n, int m) {

        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        check[n] = 1;

        while (!q.isEmpty()) {

            Integer current = q.poll();

            for (int i = -1; i < 2; i++) {

                int nextNum = 0;

                if (i ==  -1) {
                    nextNum = current + i;
                } else if (i == 0) {
                    nextNum = current * 2;
                } else if (i == 1) {
                    nextNum = current + i;
                }

                if (nextNum == m) {
                    System.out.println(check[current]);
                    return;
                }

                if (nextNum >= 0 && nextNum < check.length && check[nextNum] == 0) {
                    q.offer(nextNum);
                    check[nextNum] = check[current] + 1;
                }
            }
        }
    }
}
