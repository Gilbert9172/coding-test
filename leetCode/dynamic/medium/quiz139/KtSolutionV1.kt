package dynamic.medium.quiz139

fun main() {
    val solution = KtSolutionV1()
    val input = "aaaaaaa"
    val wordDict = listOf("aaaa", "aaa")
    val answer = solution.wordBreak(input, wordDict)
    println(answer)
}

class KtSolutionV1 {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val wordSet = HashSet(wordDict)
        val n = s.length
        val memo = BooleanArray(n + 1)
        memo[0] = true

        for (i in 1..n) {
            for (k in 0..<i) {
                val sub = s.substring(k, i)
                if (memo[k] && wordSet.contains(sub)) {
                    memo[i] = true
                    break
                }
            }
        }

        return memo[n]
    }
}
