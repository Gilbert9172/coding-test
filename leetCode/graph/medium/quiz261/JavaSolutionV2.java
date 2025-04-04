package graph.medium.quiz261;

public class JavaSolutionV2 {

    public static void main(String[] args) {
        int[][] edges = new int[][]{
                new int[]{0, 1},
                new int[]{1, 2},
                new int[]{2, 3},
                new int[]{1, 3},
                new int[]{1, 4}
        };
        JavaSolutionV2 solution = new JavaSolutionV2();
        boolean answer = solution.validTree(5, edges);
        System.out.println(answer);
    }

    private int[] parent;

    public boolean validTree(int n, int[][] edges) {
        if (edges.length == 0) return false;

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            if (!union(edge[0], edge[1])) return false;
        }
        return edges.length == n - 1;
    }

    private int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    private boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) return false;
        parent[rootY] = rootX;
        return true;
    }
}
