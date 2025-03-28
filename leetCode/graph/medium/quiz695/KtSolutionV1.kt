package graph.medium.quiz695

/**
 * [695. Max Area of Island](https://leetcode.com/problems/max-area-of-island/description/)
 */
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
    val answer = KtSolutionV1().maxAreaOfIsland(grid)
    println(answer)
}

class KtSolutionV1 {

    companion object {
        const val LAND = 1
        const val WATER = 0
    }

    private var maxRow = 0
    private var maxCol = 0
    private lateinit var map: Array<IntArray>

    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        maxRow = grid.size; maxCol = grid[0].size
        map = grid

        var maxAreaOfIsland = 0
        for (r in 0 until maxRow) {
            for (c in 0 until maxCol) {
                if (map[r][c] == LAND) {
                    val measuredArea = measureArea(r, c)
                    maxAreaOfIsland = maxOf(maxAreaOfIsland, measuredArea)
                }
            }
        }

        return maxAreaOfIsland
    }

    private fun measureArea(r: Int, c: Int): Int {
        if (!isValidPoint(r, c)) return 0
        map[r][c] = WATER

        var currArea = 0
        currArea += measureArea(r - 1, c)
        currArea += measureArea(r + 1, c)
        currArea += measureArea(r, c - 1)
        currArea += measureArea(r, c + 1)

        return currArea
    }

    private fun isValidPoint(r: Int, c: Int): Boolean {
        fun isInRange() = (r in 0 until maxRow) && (c in 0 until maxCol)
        fun isLand() = map[r][c] == LAND
        return isInRange() && isLand()
    }
}
