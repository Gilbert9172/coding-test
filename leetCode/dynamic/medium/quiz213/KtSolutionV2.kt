package dynamic.medium.quiz213

fun main() {
    val solution = KtSolutionV2()
    val nums = intArrayOf(4, 1, 2, 7, 5, 3, 1)
    val answer = solution.rob(nums)
    println(answer)
}

// memo 배열을 사용하지 않음.
// 대신 prev1, prev2 변수를 이용해 메모리 사용을 O(1)로 최적화
class KtSolutionV2 {

    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        return maxOf(
            // 마지막 집 제외
            robHouse(nums, 0, nums.size - 2),
            // 첫 번째 집 제외
            robHouse(nums, 1, nums.size - 1)
        )
    }

    // prev1 : 0 -> 4 -> 4 -> 6 -> 11 -> 11
    // prev2 : 4 -> 4 -> 6 -> 11 -> 11 -> 14

    // prev1 : 0 -> 1 -> 2 -> 8 -> 8 -> 11
    // prev2 : 0 -> 1 -> 2 -> 8 -> 8 -> 11
    private fun robHouse(nums: IntArray, start: Int, end: Int): Int {
        var prev1 = 0 // `i - 2` 위치까지 털었을 때 최대 이익
        var prev2 = 0 // `i - 1` 위치까지 털었을 때 최대 이익
        for (i in start..end) {
            val curr = maxOf(nums[i] + prev1, prev2)
            prev1 = prev2
            prev2 = curr
        }

        return maxOf(prev1, prev2)
    }
}
