package greedy.medium.quiz55

fun main() {
    val solution = KtSolutionV1()
    val nums = intArrayOf(2, 3, 1, 1, 4)
    val answer = solution.canJump(nums)
    println(answer)
}

class KtSolutionV1 {
    fun canJump(nums: IntArray): Boolean {
        var reachable = 0
        for (i in nums.indices) {
            if (i > reachable) return false
            reachable = nums[i] + i
        }
        return true
    }
}
