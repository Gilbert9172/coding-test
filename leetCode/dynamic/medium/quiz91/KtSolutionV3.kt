package dynamic.medium.quiz91

fun main() {
    val solution = KtSolutionV3()
    val answer = solution.numDecodings("226")
    println(answer)
}

// Bottom up
class KtSolutionV3 {

    fun numDecodings(s: String): Int {
        val n = s.length
        val dp = IntArray(n + 1)
        dp[n] = 1  // base case: 끝까지 해석한 경우는 1가지

        for (i in n - 1 downTo 0) {
            if (s[i] == '0') {
                dp[i] = 0  // '0'으로 시작하는 건 해석 불가
            } else {
                // 한 자리 해석
                dp[i] = dp[i + 1]

                // 두 자리 해석 (i + 1 < n 필요)
                if (i + 1 < n) {
                    val twoDigit = s.substring(i, i + 2).toInt()
                    if (twoDigit in 10..26) {
                        dp[i] += dp[i + 2]
                    }
                }
            }
        }

        return dp[0]
    }
}
