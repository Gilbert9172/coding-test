package dynamic.medium.quiz322

fun main() {
    val solution = KtSolutionV2()
    val nums = intArrayOf(2, 5, 10, 1)
    val answer = solution.coinChange(nums, 27)
    println(answer)
}

class KtSolutionV2 {

    private val initVal = -2

    fun coinChange(coins: IntArray, amount: Int): Int {
        // `amount`를 만들 수 없는 경우 반환 값이 `-1`이므로, 초기화 값을 `-2`로 설정
        val memo = IntArray(amount + 1) { initVal }
        memo[0] = 0
        return dfs(memo, coins, amount)
    }

    private fun dfs(memo: IntArray, coins: IntArray, amount: Int): Int {
        // 탈출 조건
        if (amount == 0) return 0
        if (amount < 0) return -1
        if (memo[amount] != -2) return memo[amount]

        var minCoin = Int.MAX_VALUE
        for (coin in coins) {
            val prevCnt = dfs(memo, coins, amount - coin)
            // 가능한 조합이 있다면...
            if (prevCnt >= 0) {
                minCoin = minOf(minCoin, prevCnt + 1)
            }
        }
        memo[amount] = if (minCoin == Int.MAX_VALUE) -1 else minCoin
        return memo[amount]
    }
}
