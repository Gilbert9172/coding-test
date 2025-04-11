package matrix.medium.quiz73

fun main() {
    val matrix = arrayOf(
        intArrayOf(0, 0, 0, 1),
        intArrayOf(0, 0, 0, 1),
        intArrayOf(0, 0, 0, 1),
        intArrayOf(0, 0, 0, 1)
    )
    KtSolutionV1().setZeroes(matrix)
    matrix.forEach {
        println(it.toList().toString())
    }
}

class KtSolutionV1 {

    data class Point(val x: Int, val y: Int)

    fun setZeroes(matrix: Array<IntArray>) {
        val maxRow = matrix.size
        val maxCol = matrix[0].size

        val que = ArrayDeque<Point>()
        for (r in 0 until maxRow) {
            for (c in 0 until maxCol) {
                if (matrix[r][c] == 0) que.addLast(Point(r, c))
            }
        }

        while (que.isNotEmpty()) {
            val (x, y) = que.removeFirst()
            for (r in 0 until maxRow) matrix[r][y] = 0
            for (c in 0 until maxCol) matrix[x][c] = 0
        }
    }
}
