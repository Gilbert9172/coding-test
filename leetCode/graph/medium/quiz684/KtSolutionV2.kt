package graph.medium.quiz684

/**
 * [684. Redundant Connection](https://leetcode.com/problems/redundant-connection/description/)
 */
fun main() {
    val edges = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(2, 3),
        intArrayOf(3, 4),
        intArrayOf(1, 4),
        intArrayOf(1, 5),
    )
    KtSolutionV2().findRedundantConnection(edges).apply {
        println(this.toList().toString())
    }
}

// Union by rank
class KtSolutionV2 {
    private lateinit var parent: IntArray
    private lateinit var rank: IntArray

    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        parent = IntArray(1001) { it }
        rank = IntArray(1001) { 1 }

        for ((u, v) in edges) {
            if (!union(u, v)) {
                return intArrayOf(u, v) // 사이클을 만든 간선
            }
        }

        return intArrayOf()
    }

    private fun find(x: Int): Int {
        if (parent[x] != x) {
            parent[x] = find(parent[x]) // path compression
        }
        return parent[x]
    }

    private fun union(x: Int, y: Int): Boolean {
        val rootX = find(x)
        val rootY = find(y)
        if (rootX == rootY) return false // 싸이클 발생

        // rank가 더 높은 쪽으로 붙이
        if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX
        } else if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY
        } else {
            parent[rootY] = rootX
            rank[rootX]++
        }
        return true
    }
}
