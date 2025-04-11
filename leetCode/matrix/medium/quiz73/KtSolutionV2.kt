package matrix.medium.quiz73

fun main() {
    val matrix = arrayOf(
        intArrayOf(1, 1, 2, 0),
        intArrayOf(3, 4, 0, 2),
        intArrayOf(1, 3, 1, 5)
    )
    KtSolutionV2().setZeroes(matrix)
    matrix.forEach {
        println(it.toList().toString())
    }
}

class KtSolutionV2 {
    fun setZeroes(matrix: Array<IntArray>): Array<IntArray> {
        val rows = matrix.size
        val cols = matrix[0].size

        var firstRowHasZero = false
        var firstColHasZero = false

        // Check if first row has any zero
        for (j in 0 until cols) {
            if (matrix[0][j] == 0) {
                firstRowHasZero = true
                break
            }
        }

        // Check if first column has any zero
        for (i in 0 until rows) {
            if (matrix[i][0] == 0) {
                firstColHasZero = true
                break
            }
        }

        // Use first row and first column as markers
        for (i in 1 until rows) {
            for (j in 1 until cols) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0
                    matrix[0][j] = 0
                }
            }
        }

        // Set matrix cells to 0 based on markers
        for (i in 1 until rows) {
            for (j in 1 until cols) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0
                }
            }
        }

        // Set first row to 0 if needed
        if (firstRowHasZero) {
            for (j in 0 until cols) {
                matrix[0][j] = 0
            }
        }

        // Set first column to 0 if needed
        if (firstColHasZero) {
            for (i in 0 until rows) {
                matrix[i][0] = 0
            }
        }
        return matrix
    }
}
