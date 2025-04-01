package graph.medium.quiz542

import java.util.*

/**
 * [542. 01 Matrix](https://leetcode.com/problems/01-matrix/description/)
 */
fun main() {
    val mat = arrayOf(
        intArrayOf(0, 1, 0),
        intArrayOf(0, 1, 0),
        intArrayOf(0, 1, 0),
        intArrayOf(0, 1, 0),
        intArrayOf(0, 1, 0),
        intArrayOf(0, 1, 0)
    )
    KtSolutionV1().updateMatrix(mat).forEach {
        println(it.toList().toString())
    }
}

class KtSolutionV1 {

    private var m = 0 // maxRow
    private var n = 0 // maxCol
    private val q = LinkedList<IntArray>()
    private val dirs = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))
    private lateinit var memo: Array<IntArray>

    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        m = mat.size; n = mat[0].size
        memo = Array(m) { IntArray(n) { Int.MAX_VALUE } }

        for (r in 0 until m) {
            for (c in 0 until n) {
                if (mat[r][c] == 1) {
                    q.offer(intArrayOf(r, c, 0))
                    bfs(r, c, mat)
                }
                if (mat[r][c] == 0) {
                    memo[r][c] = 0
                }
            }
        }
        return memo
    }

    private fun bfs(start: Int, end: Int, mat: Array<IntArray>) {
        while (q.isNotEmpty()) {
            val (r, c, distance) = q.poll()
            for ((x, y) in dirs) {
                val nr = r + x
                val nc = c + y

                if (nr in 0 until m && nc in 0 until n) {
                    if (mat[nr][nc] == 0) {
                        memo[start][end] = minOf(distance + 1, memo[r][c])
                        break
                    }
                    q.offer(intArrayOf(nr, nc, distance + 1))
                }
            }
        }
    }
}
