package dynamic.medium.quiz213

fun main() {
    val solution = KtSolutionV1()
    val nums = intArrayOf(4, 1, 2, 7, 5, 3, 1)
    val answer = solution.rob(nums)
    println(answer)
}

class KtSolutionV1 {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]

        val skipLastHouse = robHouse(nums.copyOfRange(0, nums.size - 1))
        val skipFirstHouse = robHouse(nums.copyOfRange(1, nums.size))

        return maxOf(skipLastHouse, skipFirstHouse)
    }

    private fun robHouse(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        if (nums.size == 1) return nums[0]

        val memo = IntArray(nums.size)

        memo[0] = nums[0]
        memo[1] = maxOf(nums[0], nums[1])

        for (i in 2 until nums.size) {
            memo[i] = maxOf(memo[i - 1], nums[i] + memo[i - 2])
        }

        return memo.last()
    }
}
