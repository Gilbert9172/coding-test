package dynamic.medium.quiz213

fun main() {
    val solution = KtSolutionV2()
    val nums = intArrayOf(4, 1, 2, 7, 5, 3, 1)
    val answer = solution.rob(nums)
    println(answer)
}

class KtSolutionV2 {

    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]

        fun robHouse(start: Int, end: Int): Int {
            var prev1 = 0
            var prev2 = 0
            for (i in start..end) {
                val curr = maxOf(nums[i] + prev1, prev2)
                prev1 = prev2
                prev2 = curr
            }

            return maxOf(prev1, prev2)
        }

        return maxOf(robHouse(0, nums.size - 2), robHouse(1, nums.size - 1))
    }
}
