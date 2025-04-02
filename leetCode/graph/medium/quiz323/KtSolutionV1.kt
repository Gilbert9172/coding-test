package graph.medium.quiz323

fun main() {
    //Input: n = 5, edges = [[0,1],[1,2],[3,4]]
    // Input: n = 5, edges = [[0,1],[1,2],[2,3],[3,4]]
    val n = 5
    val edges = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(1, 2),
        intArrayOf(2, 3),
        intArrayOf(3, 4)
    )
    KtSolutionV1().countComponents(n, edges).apply {
        println(this)
    }

}

class KtSolutionV1 {

    private lateinit var adjArr: MutableMap<Int, MutableList<Int>>
    private lateinit var visited: BooleanArray

    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        adjArr = mutableMapOf()
        edges.forEach { (from, to) ->
            adjArr.computeIfAbsent(from) { mutableListOf() }.add(to)
            adjArr.computeIfAbsent(to) { mutableListOf() }.add(from)
        }

        visited = BooleanArray(n) { false }

        var components = 0
        for (node in visited.indices) {
            if (!visited[node]) {
                generateGraph(node)
                components++
            }
        }

        return components
    }

    private fun generateGraph(node: Int) {
        visited[node] = true
        for (neighbor in adjArr[node] ?: emptyList()) {
            if (!visited[neighbor]) {
                generateGraph(neighbor)
            }
        }
    }
}
