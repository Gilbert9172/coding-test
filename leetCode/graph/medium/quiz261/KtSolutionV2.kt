package graph.medium.quiz261

/**
 * [261. Graph Valid Tree](https://leetcode.ca/2016-08-17-261-Graph-Valid-Tree/)
 */
fun main() {
    val n = 5
    val edges = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(0, 2),
        intArrayOf(0, 3),
        intArrayOf(1, 4)
    )
    KtSolutionV2().validTree(n, edges).apply {
        println(this)
    }
}

class KtSolutionV2 {

    private lateinit var parent: IntArray

    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
        parent = IntArray(n) { it }

        for ((x, y) in edges) {
            if (!union(x, y)) return false
        }

        // 간선 수가 정확히 n - 1인지 확인 (이거 없으면 forest도 true됨)
        return edges.size == n - 1
    }

    private fun find(node: Int): Int {
        if (parent[node] != node) {
            parent[node] = find(parent[node])
        }
        return parent[node]
    }

    private fun union(x: Int, y: Int): Boolean {
        val rootX = find(x)
        val rootY = find(y)
        if (rootX == rootY) return false
        parent[rootY] = rootX
        return true
    }
}
