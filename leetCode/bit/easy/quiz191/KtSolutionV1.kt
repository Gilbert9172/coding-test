package bit.easy.quiz191

/**
 * [191. Number of 1 Bits](https://leetcode.com/problems/number-of-1-bits/description/)
 */
fun main() {
    val solution = KtSolutionV1()
    val answer = solution.hammingWeight(11)
    println(answer)
}

class KtSolutionV1 {
    fun hammingWeight(n: Int): Int {
        var count = 0
        val binaryNum = Integer.toBinaryString(n)
        for (i in binaryNum.indices) {
            if (binaryNum[i] == '1') count++
        }
        return count
    }
}
