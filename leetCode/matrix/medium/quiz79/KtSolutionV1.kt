package matrix.medium.quiz79

fun main() {
    val board = arrayOf(
        charArrayOf('A')
    )
    val answer = KtSolutionV1().exist(board, "B")
    println(answer)
}

class KtSolutionV1 {

    private var m = 0
    private var n = 0
    private val dirs = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))
    private lateinit var visited: Array<BooleanArray>

    fun exist(board: Array<CharArray>, word: String): Boolean {
        m = board.size
        n = board[0].size

        for (r in 0 until m) {
            for (c in 0 until n) {
                visited = Array(m) { BooleanArray(n) }
                visited[r][c] = true

                val sb = StringBuilder()
                sb.append(board[r][c])

                val answer = dfs(r, c, 0, word, board, sb)
                if (answer == word) return true
            }
        }
        return false
    }

    private fun dfs(r: Int, c: Int, pId: Int, word: String, board: Array<CharArray>, bucket: StringBuilder): String {
        if (pId == word.lastIndex) return bucket.toString()

        for ((x, y) in dirs) {
            val nr = r + x
            val nc = c + y

            if (nr in 0 until m && nc in 0 until n && word[pId + 1] == board[nr][nc] && !visited[nr][nc]) {
                visited[nr][nc] = true
                bucket.append(board[nr][nc])
                val string = dfs(nr, nc, pId + 1, word, board, bucket)
                if (string.length == word.length) return string
                bucket.deleteCharAt(bucket.lastIndex)
                visited[nr][nc] = false
            }
        }
        return ""
    }
}
