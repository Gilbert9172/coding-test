package graph.medium.quiz994

import java.util.*

/**
 * [994. Rotting Oranges](https://leetcode.com/problems/rotting-oranges/description/)
 */
fun main() {
    val grid = arrayOf(
        intArrayOf(2, 1, 1),
        intArrayOf(1, 1, 0),
        intArrayOf(0, 1, 1)
    )
    val answer = KtSolutionV1().orangesRotting(grid)
    println(answer)
}

class KtSolutionV1 {
    private var m = 0
    private var n = 0
    private val que = LinkedList<IntArray>()
    private val dirs = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))

    fun orangesRotting(grid: Array<IntArray>): Int {
        m = grid.size; n = grid[0].size

        var freshCount = 0
        for (r in 0 until m) {
            for (c in 0 until n) {
                when (grid[r][c]) {
                    2 -> que.offer(intArrayOf(r, c, 0))
                    1 -> freshCount++
                }
            }
        }

        var minutes = 0
        while (que.isNotEmpty()) {
            val (cr, cc, minute) = que.poll()
            minutes = maxOf(minutes, minute)

            for ((x, y) in dirs) {
                val nr = cr + x
                val nc = cc + y

                if (nr in 0 until m && nc in 0 until n && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2
                    freshCount--
                    que.offer(intArrayOf(nr, nc, minute + 1))
                }
            }
        }

        return if (freshCount == 0) minutes else -1
    }
}
