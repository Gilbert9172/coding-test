package graph.medium.quiz130

/**
 * [130. Surrounded Regions](https://leetcode.com/problems/surrounded-regions/)
 */
fun main() {
    val board = arrayOf(
        charArrayOf('X', 'X', 'X', 'X'),
        charArrayOf('X', 'O', 'O', 'X'),
        charArrayOf('X', 'X', 'O', 'X'),
        charArrayOf('X', 'X', 'O', 'X'),
    )
    KtSolutionV2().solve(board)
    board.forEach { println(it.toList().toString()) }
}

class KtSolutionV2 {

    companion object {
        const val LAND = 'O'
        const val WALL = 'X'
    }

    private var m = 0
    private var n = 0
    private val dirs = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))
    private lateinit var visited: Array<BooleanArray>

    fun solve(board: Array<CharArray>) {
        m = board.size; n = board[0].size
        visited = Array(m) { BooleanArray(n) }

        for (r in 0 until m) {
            for (c in 0 until n) {
                if (isOnEdge(r, c) && board[r][c] == LAND) {
                    dfs(r, c, board)
                }
            }
        }

        for (r in 0 until m) {
            for (c in 0 until n) {
                if (board[r][c] == LAND && !visited[r][c]) {
                    board[r][c] = WALL
                }
            }
        }
    }

    private fun dfs(r: Int, c: Int, board: Array<CharArray>) {
        visited[r][c] = true
        for ((x, y) in dirs) {
            val nr = r + x
            val nc = c + y
            if (isValidPoint(nr, nc, board)) {
                dfs(nr, nc, board)
            }
        }
    }

    private fun isOnEdge(r: Int, c: Int) = r == 0 || r == m - 1 || c == 0 || c == n - 1

    private fun isValidPoint(r: Int, c: Int, board: Array<CharArray>): Boolean {
        fun isInRange() = (r in 0 until m) && (c in 0 until n)
        fun isNotVisited() = !visited[r][c]
        fun isLand() = board[r][c] == LAND
        return isInRange() && isNotVisited() && isLand()
    }
}
