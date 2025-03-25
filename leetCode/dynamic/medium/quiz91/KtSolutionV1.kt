package dynamic.medium.quiz91

fun main() {
    val solution = KtSolutionV1()
    val answer = solution.numDecodings("226")
    println(answer)
}

// Top down - memo(Map)
class KtSolutionV1 {

    fun numDecodings(s: String): Int {
        val memo = mutableMapOf<Int, Int>()
        return dfs(s, 0, memo)
    }

    private fun dfs(s: String, i: Int, memo: MutableMap<Int, Int>): Int {
        when {
            i in memo -> return memo[i]!!
            i == s.length -> return 1
            s[i] == '0' -> return 0
        }

        // 한 글자 해석 가능한 경우
        var result = dfs(s, i + 1, memo)

        // 두 글자 해석 가능한 경우
        if (i + 1 < s.length) {
            val twoDigit = s.substring(i, i + 2).toInt()
            if (twoDigit in 10..26) {
                result += dfs(s, i + 2, memo)
            }
        }

        memo[i] = result
        return memo[i]!!
    }
}
