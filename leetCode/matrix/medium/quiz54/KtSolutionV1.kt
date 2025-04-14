package matrix.medium.quiz54

fun main() {
    val matrix = arrayOf(
        intArrayOf(1)
    )
    val spiralOrder = KtSolutionV1().spiralOrder(matrix)
    println(spiralOrder.toString())
}

class KtSolutionV1 {

    private val result = mutableListOf<Int>()
    private var m = 0
    private var n = 0
    private lateinit var visited: Array<BooleanArray>

    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        m = matrix.size
        n = matrix[0].size

        visited = Array(m) { BooleanArray(n) }

        generateResult(matrix)
        return result
    }

    private fun generateResult(matrix: Array<IntArray>) {
        var x = 0
        var y = 0
        while ((x in 0 until m) && (y in 0 until n)) {
            val rightEnd = n - y
            val bottomEnd = m - x
            val leftEnd = n - 2 - y
            val topEnd = m - 2 - x

            // 우측 방향
            for (c1 in y until rightEnd) {
                if (visited[x][c1]) break
                result.add(matrix[x][c1])
                visited[x][c1] = true
            }

            // 아랫 방향
            for (r1 in x + 1 until bottomEnd) {
                if (visited[r1][n - 1 - y]) break
                result.add(matrix[r1][n - 1 - y])
                visited[r1][n - 1 - y] = true
            }

            // 왼쪽 방향
            for (c2 in leftEnd downTo y) {
                if (visited[m - 1 - x][c2]) break
                result.add(matrix[m - 1 - x][c2])
                visited[m - 1 - x][c2] = true
            }

            // 윗 방향
            for (r2 in topEnd downTo x + 1) {
                if (visited[r2][y]) break
                result.add(matrix[r2][y])
                visited[r2][y] = true
            }

            // 시작점 갱신
            x++
            y++
        }
    }
}
