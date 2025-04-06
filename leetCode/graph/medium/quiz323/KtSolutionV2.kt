package graph.medium.quiz323

/**
 * [323. Number of Connected Components in an Undirected Graph](https://leetcode.ca/2016-10-18-323-Number-of-Connected-Components-in-an-Undirected-Graph/)
 */
fun main() {
    val n = 5
    val edges = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(1, 2),
        intArrayOf(2, 3),
        intArrayOf(3, 4)
    )
    KtSolutionV2().countComponents(n, edges).apply {
        println(this)
    }

}

class KtSolutionV2 {

    private lateinit var parent: IntArray
    private lateinit var rank: IntArray


    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        parent = IntArray(n) { it }
        rank = IntArray(n) { 1 }

        var res = n
        for (edge in edges) {
            val (u, v) = edge
            if (union(u, v)) res--
        }
        return res
    }

    private fun find(node: Int): Int {
        if (parent[node] != node) {
            parent[node] = find(parent[node])
        }
        return parent[node]
    }

    private fun union(u: Int, v: Int): Boolean {
        val pu = find(u)
        val pv = find(v)
        if (pu == pv) return false

        if (rank[pv] > rank[pu]) {
            parent[pu] = pv
        } else if (rank[pv] < rank[pu]) {
            parent[pv] = pu
        } else {
            parent[pu] = pv
            rank[pv]++
        }
        return true
    }
}
