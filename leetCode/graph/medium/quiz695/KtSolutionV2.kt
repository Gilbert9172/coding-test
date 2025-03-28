package graph.medium.quiz695

import java.util.*

fun main() {
    val grid = arrayOf(
        intArrayOf(0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
        intArrayOf(0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0),
        intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0),
        intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0)
    )
    val answer = KtSolutionV2().maxAreaOfIsland(grid)
    println(answer)
}

class KtSolutionV2 {
    data class Point(val r: Int, val c: Int)

    companion object {
        const val LAND = 1
        const val WATER = 0
    }

    private var maxRow = 0
    private var maxCol = 0
    private val dirs = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))
    private lateinit var map: Array<IntArray>
    private val que = LinkedList<Point>()

    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        maxRow = grid.size; maxCol = grid[0].size
        map = grid

        var maxAreaOfIsland = 0
        for (r in 0 until maxRow) {
            for (c in 0 until maxCol) {
                if (map[r][c] == LAND) {
                    map[r][c] = WATER
                    que.offer(Point(r, c))
                    val measuredArea = measureArea()
                    maxAreaOfIsland = maxOf(maxAreaOfIsland, measuredArea)
                }
            }
        }

        return maxAreaOfIsland
    }

    private fun measureArea(): Int {
        var currArea = 1
        while (!que.isEmpty()) {
            val (cr, cc) = que.poll()
            for ((x, y) in dirs) {
                val nr = cr + x
                val nc = cc + y

                if (isValidPoint(nr, nc)) {
                    currArea++
                    map[nr][nc] = WATER
                    que.offer(Point(nr, nc))
                }
            }
        }
        return currArea
    }

    private fun isValidPoint(r: Int, c: Int): Boolean {
        fun isInRange() = (r in 0 until maxRow) && (c in 0 until maxCol)
        fun isLand() = map[r][c] == LAND
        return isInRange() && isLand()
    }
}
