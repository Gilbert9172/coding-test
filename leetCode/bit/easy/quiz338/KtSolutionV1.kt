package bit.easy.quiz338


fun main() {
    val solution = KtSolutionV1()
    val answer = solution.countBits(5)
    println(answer.contentToString())
}

/**
 * [338. Counting Bits](https://leetcode.com/problems/counting-bits/description/)
 */
class KtSolutionV1 {
    fun countBits(n: Int): IntArray {
        val result = IntArray(n + 1) { 0 }
        for (i in 0..n) {
            result[i] = countOneBit(i)
        }
        return result
    }

    private fun countOneBit(n: Int): Int {
        var count = 0
        var num = n
        while (num != 0) {
            count += num and 1
            num = num shr 1
        }
        return count
    }
}
