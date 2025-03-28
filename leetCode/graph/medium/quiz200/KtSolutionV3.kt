package graph.medium.quiz200

import java.util.*

/**
 * [200. Number of Islands](https://leetcode.com/problems/number-of-islands/)
 */
fun main() {
    val grid = arrayOf(
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('0', '0', '1', '0', '0'),
        charArrayOf('0', '0', '0', '1', '1'),
    )

    val solution = KtSolutionV3()
    val answer = solution.numIslands(grid)
    println(answer)
}

// BFS
class KtSolutionV3 {

    companion object {
        const val WATER = '0'
        const val LAND = '1'
    }

    private var maxRow: Int = 0
    private var maxCol: Int = 0
    private val dirs = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))
    private lateinit var map: Array<CharArray>
    private var que = LinkedList<Point>()

    data class Point(val x: Int, val y: Int) {
        fun nextX(step: Int): Int = x + step
        fun nextY(step: Int): Int = y + step
    }

    fun numIslands(grid: Array<CharArray>): Int {
        maxRow = grid.size; maxCol = grid[0].size
        map = grid

        var countOfIsland = 0
        for (r in 0..<maxRow) {
            for (c in 0..<maxCol) {
                if (map[r][c] == LAND) {
                    map[r][c] = WATER
                    que.offer(Point(r, c))
                    searchLandFrom()
                    countOfIsland++
                }
            }
        }

        return countOfIsland
    }

    private fun searchLandFrom() {
        while (!que.isEmpty()) {
            val point = que.poll()
            for (dir in dirs) {
                val nr = point.nextX(dir[0])
                val nc = point.nextY(dir[1])

                if (!isValidPoint(nr, nc)) continue

                map[nr][nc] = WATER
                que.offer(Point(nr, nc))
            }
        }
    }

    private fun isValidPoint(r: Int, c: Int): Boolean {
        fun isInRange() = r < maxRow && c < maxCol && r >= 0 && c >= 0
        fun isLand() = map[r][c] == LAND
        return isInRange() && isLand()
    }
}
