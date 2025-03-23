package dynamic.medium.quiz1143

fun main() {
    val solution = KtSolutionV1()
    val text1 = "abcd"
    val text2 = "dbca"
    val answer = solution.longestCommonSubsequence(text1, text2)
    println(answer)
}

// 2D - [Tabulation] Bottom up memoization
class KtSolutionV1 {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val maxRow = text1.length
        val maxCol = text2.length

        // Initialize 2D memoization array
        val memo = Array(maxRow + 1) { IntArray(maxCol + 1) }

        for (r in 1..maxRow) {
            for (c in 1..maxCol) {
                when {
                    text1[r - 1] == text2[c - 1] -> memo[r][c] = memo[r - 1][c - 1] + 1
                    else -> memo[r][c] = maxOf(memo[r - 1][c], memo[r][c - 1])
                }
            }
        }

        return memo[maxRow][maxCol]
    }
}
