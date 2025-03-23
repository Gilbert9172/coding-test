package dynamic.medium.quiz1143

fun main() {
    val solution = KtSolutionV3()
    val text1 = "abcde"
    val text2 = "ace"
    val answer = solution.longestCommonSubsequence(text1, text2)
    println(answer)
}

// 1D - Optimized Bottom up memoization
class KtSolutionV3 {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val x = text1.length
        val y = text2.length

        val memo = IntArray(y + 1)

        for (i in 1..x) {
            // 대각선
            var prev = 0
            for (k in 1..y) {
                // 같은 행 윗 열
                val temp = memo[k]
                if (text1[i - 1] == text2[k - 1]) {
                    memo[k] = 1 + prev
                } else {
                    // memo[k - 1] : 같은 열 왼쪽 행
                    memo[k] = maxOf(memo[k], memo[k - 1])
                }
                prev = temp
            }
        }
        return memo[y]
    }
}
