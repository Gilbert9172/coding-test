package graph.medium.quiz542

/**
 * [542. 01 Matrix](https://leetcode.com/problems/01-matrix/description/)
 */
fun main() {
    val mat = arrayOf(
        intArrayOf(0, 0, 0),
        intArrayOf(0, 1, 0),
        intArrayOf(1, 1, 1)
    )
    KtSolutionV2().updateMatrix(mat).forEach {
        println(it.toList().toString())
    }
}

class KtSolutionV2 {
    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        val m = mat.size
        val n = mat[0].size
        val q: ArrayDeque<IntArray> = ArrayDeque()
        val dirs = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))

        val dist = Array(m) { IntArray(n) { Int.MAX_VALUE } }

        // 0인 위치는 큐에 먼저 넣고 거리 0으로 초기화
        for (r in 0 until m) {
            for (c in 0 until n) {
                if (mat[r][c] == 0) {
                    q.addLast(intArrayOf(r, c))
                    dist[r][c] = 0
                }
            }
        }

        // BFS 시작
        while (q.isNotEmpty()) {
            val (r, c) = q.removeFirst()
            for ((dr, dc) in dirs) {
                val nr = r + dr
                val nc = c + dc
                if (nr in 0 until m && nc in 0 until n) {
                    if (dist[nr][nc] > dist[r][c] + 1) {
                        dist[nr][nc] = dist[r][c] + 1
                        q.addLast(intArrayOf(nr, nc))
                    }
                }
            }
        }

        return dist
    }
}
