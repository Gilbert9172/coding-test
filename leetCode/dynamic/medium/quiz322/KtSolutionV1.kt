package dynamic.medium.quiz322

fun main() {
    val solution = KtSolutionV1()
    val nums = intArrayOf(2, 5, 10, 1)
    val answer = solution.coinChange(nums, 27)
    println(answer)
}

class KtSolutionV1 {

    fun coinChange(coins: IntArray, amount: Int): Int {
        when {
            amount == 0 -> return 0
            amount < 0 -> return -1
        }

        val memo = IntArray(amount + 1) { amount + 1 }
        memo[0] = 0

        for (i in 1..amount) {
            for (coin in coins) {
                if (i - coin >= 0) {
                    memo[i] = minOf(memo[i], memo[i - coin] + 1)
                }
            }
        }

        return when {
            (memo[amount] == amount + 1) -> -1
            else -> memo[amount]
        }
    }
}
