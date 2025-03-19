package dynamic.easy.quiz70

fun main() {
    val solution = KtSolutionV1()
    val answer = solution.climbStairs(5)
    println(answer)
}

/**
 * [70. Climbing Stairs](https://leetcode.com/problems/climbing-stairs/description/)
 */
class KtSolutionV1 {
    fun climbStairs(n: Int): Int {
        val steps = IntArray(46) { 0 }
        for (i in 0..n) {
            when {
                i < 3 -> steps[i] = i
                else -> steps[i] = steps[i - 1] + steps[i - 2]
            }
        }
        return steps[n]
    }
}
