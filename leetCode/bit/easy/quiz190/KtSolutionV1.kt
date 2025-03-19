package bit.easy.quiz190

fun main() {
    val solution = KtSolutionV1()
    val answer = solution.reverseBits(0b00000010100101000001111010011100)
    println(answer)
}

/**
 * [190. Reverse Bits](https://leetcode.com/problems/reverse-bits/description/)
 */
class KtSolutionV1 {
    fun reverseBits(n: Int): Int {
        var result = 0
        var num = n

        for (i in 0 until 32) {
            result = (result shl 1) or (num and 1)
            num = num ushr 1
        }

        return result
    }

}
