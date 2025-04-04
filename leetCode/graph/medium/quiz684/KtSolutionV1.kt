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
    KtSolutionV1().findRedundantConnection(edges).apply {
        println(this.toList().toString())
    }
}

// Path Compression(경로 압축)
class KtSolutionV1 {

    private lateinit var parent: IntArray

    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        parent = IntArray(1001) { it }

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
        parent[rootY] = rootX // Union
        return true
    }
}
