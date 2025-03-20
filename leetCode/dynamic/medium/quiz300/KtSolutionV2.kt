package dynamic.medium.quiz300

fun main() {
    val solution = KtSolutionV2()
    val nums = intArrayOf(0, 1, 0, 3, 2, 3)
    val answer = solution.lengthOfLIS(nums)
    println(answer)
}

class KtSolutionV2 {

    fun lengthOfLIS(nums: IntArray): Int {
        val numSize = nums.size
        val memo = IntArray(numSize) { 1 }
        var max = 1

        for (i in numSize - 2 downTo 0) {
            var currIdx = i + 1
            while (currIdx < numSize) {
                if (nums[i] < nums[currIdx]) {
                    memo[i] = maxOf(memo[i], memo[currIdx] + 1)
                    max = maxOf(max, memo[i])
                }
                currIdx++
            }
        }

        return max
    }

}
