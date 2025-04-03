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
    KtSolutionV1().solve(board)
    board.forEach { println(it.toList().toString()) }
}

class KtSolutionV1 {

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
            if (board[r][0] == LAND && !visited[r][0]) {
                dfs(r, 0, board)
            }
            if (board[r][n - 1] == LAND && !visited[r][n - 1]) {
                dfs(r, n - 1, board)
            }
        }

        for (c in 0 until n) {
            if (board[0][c] == LAND && !visited[0][c]) {
                dfs(0, c, board)
            }
            if (board[m - 1][c] == LAND && !visited[m - 1][c]) {
                dfs(m - 1, c, board)
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

    private fun isValidPoint(r: Int, c: Int, board: Array<CharArray>): Boolean {
        fun isInRange() = (r in 0 until m) && (c in 0 until n)
        fun isNotVisited() = !visited[r][c]
        fun isLand() = board[r][c] == LAND
        return isInRange() && isNotVisited() && isLand()
    }
}
