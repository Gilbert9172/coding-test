package dynamic.medium.quiz198

fun main() {
    val solution = KtSolutionV3()
    val nums = intArrayOf(2, 7, 9, 3, 1)
    val answer = solution.rob(nums)
    println(answer)
}

class KtSolutionV3 {
    fun rob(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        if (nums.size == 1) return nums[0]

        val memo = IntArray(nums.size)
        memo[0] = nums[0]
        memo[1] = maxOf(nums[0], nums[1])

        for (i in 2 until nums.size) {
            memo[i] = maxOf(memo[i - 1], memo[i - 2] + nums[i])
        }

        return memo.last()
    }
}
