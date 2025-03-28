package hashmap.medium.quiz128

/**
 * [128. Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/description/)
 */
fun main() {
    val nums = intArrayOf(1, 1, 0, 2)
    val answer = KtSolutionV1().longestConsecutive(nums)
    println(answer)
}

class KtSolutionV1 {
    fun longestConsecutive(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        nums.sort()

        var maxLen = 1
        var currLen = 1
        var prev = nums[0]
        var next = prev + 1

        for ((i, value) in nums.withIndex()) {
            if (i == 0 || prev == value) continue

            currLen = if (value == next) currLen + 1 else 1

            maxLen = maxOf(maxLen, currLen)
            prev = value
            next = prev + 1
        }

        return maxLen
    }
}
