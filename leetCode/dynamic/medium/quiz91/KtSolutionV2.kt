package dynamic.medium.quiz91

fun main() {
    val solution = KtSolutionV2()
    val answer = solution.numDecodings("226")
    println(answer)
}

// Top down - memo(IntArray)
class KtSolutionV2 {

    fun numDecodings(s: String): Int {
        val memo = IntArray(s.length + 1) { -1 }
        return dfs(s, 0, memo)
    }

    fun dfs(s: String, i: Int, memo: IntArray): Int {
        when {
            memo[i] != -1 -> return memo[i]
            i == s.length -> return 1
            s[i] == '0' -> return 0
        }

        var result = dfs(s, i + 1, memo)

        if (i + 1 < s.length) {
            val twoDigit = s.substring(i, i + 2).toInt()
            if (twoDigit in 10..26) {
                result += dfs(s, i + 2, memo)
            }
        }

        memo[i] = result
        return result
    }
}
