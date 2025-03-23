package dynamic.medium.quiz1143

fun main() {
    val solution = KtSolutionV2()
    val text1 = "abcde"
    val text2 = "ace"
    val answer = solution.longestCommonSubsequence(text1, text2)
    println(answer)
}

// 1D - Optimized Bottom up memoization
class KtSolutionV2 {
    fun longestCommonSubsequence(text1: String, text2: String): Int {

        val memo = IntArray(text1.length)

        var maxLength = 0
        for (c in text2.toCharArray()) {
            // currentLength: 상황에 따라 dp[i][j-1] 또는 dp[i-1][j-1]의 역할을 하는 가변적 추적 변수
            var currentLength = 0
            for (k in memo.indices) {
                // memo[k] = dp[i-1][k] : 테이블로 치면 같은 열의 윗쪽 행
                // currentLength = dp[i][k-1] : 테이블로 치면 같은 행의 왼쪽 열
                if (currentLength < memo[k]) {
                    currentLength = memo[k]
                }
                // currentLength = dp[i-1][j-1]
                else if (text1[k] == c) {
                    memo[k] = currentLength + 1
                    maxLength = maxOf(maxLength, memo[k])
                }
            }
        }
        return maxLength
    }
}
