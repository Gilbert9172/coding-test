package dynamic.medium.quiz198

fun main() {
    val solution = KtSolutionV2()
    val nums = intArrayOf(2, 7, 9, 3, 1)
    val answer = solution.rob(nums)
    println(answer)
}

class KtSolutionV2 {
    fun rob(nums: IntArray): Int {
        val memo = IntArray(nums.size) { 0 }

        var maxProfit = nums[0]
        for (i in nums.indices) {
            memo[i] = maxOf(memo[i], nums[i])
            maxProfit = maxOf(maxProfit, memo[i])
            for (k in i + 2..nums.lastIndex) {
                memo[k] = maxOf(memo[i] + nums[k], memo[k])
            }
        }

        return maxProfit
    }
}
