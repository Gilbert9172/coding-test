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
    KtSolutionV1().validTree(n, edges).apply {
        println(this)
    }
}

class KtSolutionV1 {

    data class Point(val current: Int, val parent: Int)

    fun validTree(n: Int, edges: Array<IntArray>): Boolean {

        // 주어진 노드를 바탕으로 Graph 초기화
        val graph = mutableMapOf<Int, MutableList<Int>>()
        edges.forEach { (from, to) ->
            graph.computeIfAbsent(from) { mutableListOf() }.add(to)
            graph.computeIfAbsent(to) { mutableListOf() }.add(from)
        }

        // BFS
        val visited = mutableSetOf<Int>()
        val que = ArrayDeque<Point>()
        que.addLast(Point(0, -1))

        while (que.isNotEmpty()) {
            val (current, parent) = que.removeFirst()
            visited += current

            for (neighbor in graph[current] ?: emptyList()) {
                // 이웃이 이미 방문되어 있고, 부모가 아니라면
                if (visited.contains(neighbor)) {
                    if (neighbor != parent) return false
                    else continue
                }
                que.addLast(Point(neighbor, current))
            }
        }

        return visited.size == n
    }
}
