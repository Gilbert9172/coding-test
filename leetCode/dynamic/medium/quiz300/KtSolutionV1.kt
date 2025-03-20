package dynamic.medium.quiz300

fun main() {
    val solution = KtSolutionV1()
    val nums = intArrayOf(0, 1, 0, 3, 2, 3)
    val answer = solution.lengthOfLIS(nums)
    println(answer)
}

class KtSolutionV1 {
    fun lengthOfLIS(nums: IntArray): Int {
        val memo = IntArray(nums.size) { 1 }
        var max = 1
        for (i in 0..nums.lastIndex) {
            for (k in 0..i) {
                if (nums[k] < nums[i]) {
                    memo[i] = maxOf(memo[i], memo[k] + 1)
                    max = maxOf(memo[i], max)
                }
            }
        }
        return max
    }
}
