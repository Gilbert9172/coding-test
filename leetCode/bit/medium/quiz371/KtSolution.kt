package bit.medium.quiz371

/**
 * [371. Sum of Two Integers](https://leetcode.com/problems/sum-of-two-integers/description/)
 */
fun main() {
    val solution = KtSolution()
    val answer = solution.getSum(2, 3)
    println(answer)
}

class KtSolution {

    fun getSum(a: Int, b: Int): Int {
        var x = a
        var y = b

        while (y != 0) {
            val submitWithoutCarry = x xor y
            val carry = (x and y) shl 1
            x = submitWithoutCarry
            y = carry
        }

        return x
    }
}
