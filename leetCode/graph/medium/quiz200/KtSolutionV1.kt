package graph.medium.quiz200

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

    val solution = KtSolutionV1()
    val answer = solution.numIslands(grid)
    println(answer)
}

// DFS
class KtSolutionV1 {

    companion object {
        const val WATER = '0'
        const val LAND = '1'
    }

    private var maxRow: Int = 0
    private var maxCol: Int = 0
    private lateinit var map: Array<CharArray>

    fun numIslands(grid: Array<CharArray>): Int {
        maxRow = grid.size; maxCol = grid[0].size
        map = grid

        var countOfIsland = 0
        for (r in 0..<maxRow) {
            for (c in 0..<maxCol) {
                if (map[r][c] == LAND) {
                    searchLandFrom(r, c)
                    countOfIsland++
                }
            }
        }

        return countOfIsland
    }

    private fun searchLandFrom(row: Int, col: Int): Boolean {
        if (!isValidPoint(row, col)) return false
        map[row][col] = WATER

        val up = searchLandFrom(row - 1, col)
        val down = searchLandFrom(row + 1, col)
        val right = searchLandFrom(row, col + 1)
        val left = searchLandFrom(row, col - 1)

        return up || down || left || right
    }

    private fun isValidPoint(r: Int, c: Int): Boolean {
        fun isInRange() = r < maxRow && c < maxCol && r >= 0 && c >= 0
        fun isLand() = map[r][c] == KtSolutionV2.LAND
        return isInRange() && isLand()
    }
}
