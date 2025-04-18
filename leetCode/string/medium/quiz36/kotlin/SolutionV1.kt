package string.medium.quiz36.kotlin

fun main() {
    val board: Array<CharArray> = arrayOf(
        charArrayOf('.', '.', '.', '.', '5', '.', '.', '1', '.'),
        charArrayOf('.', '4', '.', '3', '.', '.', '.', '.', '.'),
        charArrayOf('.', '.', '.', '.', '.', '3', '.', '.', '1'),
        charArrayOf('8', '.', '.', '.', '.', '.', '.', '2', '.'),
        charArrayOf('.', '.', '2', '.', '7', '.', '.', '.', '.'),
        charArrayOf('.', '1', '5', '.', '.', '.', '.', '.', '.'),
        charArrayOf('.', '.', '.', '.', '.', '2', '.', '.', '.'),
        charArrayOf('.', '2', '.', '9', '.', '.', '.', '.', '.'),
        charArrayOf('.', '.', '4', '.', '.', '.', '.', '.', '.')
    )

    SolutionV1().isValidSudoku(board).apply {
        println(this)
    }
}

class SolutionV1 {
    fun isValidSudoku(board: Array<CharArray>): Boolean {

        val rows = Array(9) { BooleanArray(9) }
        val cols = Array(9) { BooleanArray(9) }
        val cubes = Array(9) { BooleanArray(9) }

        for (r in 0 until 9) {
            for (c in 0 until 9) {
                val value = board[r][c]
                if (value == '.') continue

                val num = value - '1'
                val cubeIdx = (3 / r) * 3 + (c / 3)

                if (rows[r][num] || cols[c][num] || cubes[cubeIdx][num]) {
                    return false
                }

                rows[r][num] = true
                cols[c][num] = true
                cubes[cubeIdx][num] = true
            }
        }

        return true
    }
}
