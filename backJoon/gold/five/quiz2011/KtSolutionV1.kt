package gold.five.quiz2011

/**
 * [암호코드](https://www.acmicpc.net/problem/2011)
 */
fun main() {
    val answer = KtSolutionV1().decodeNumbers("25114")
    println(answer)
}

class KtSolutionV1 {
    fun decodeNumbers(password: String): Int {

        val pwLen = password.length
        val memo = IntArray(pwLen + 1)
        memo[pwLen] = 1

        for (i in pwLen - 1 downTo 0) {
            if (password[i] == '0') {
                memo[i] = 0
            } else {
                // 1자리 경우
                memo[i] = memo[i + 1]

                // 2자리 경우
                if (i + 1 < pwLen) {
                    val twoDigit = password.substring(i, i + 2).toInt()
                    if (twoDigit in 10..26) {
                        memo[i] += memo[i + 2]
                    }
                }
            }
        }
        return memo[0] % 1000000
    }
}
