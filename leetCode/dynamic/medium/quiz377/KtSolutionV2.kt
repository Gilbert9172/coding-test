package dynamic.medium.quiz377

fun main() {
    val solution = KtSolutionV2()
    val nums = intArrayOf(1, 2, 3)
    val target = 4
    val answer = solution.combinationSum4(nums, target)
    println(answer)
}

class KtSolutionV2 {
    fun combinationSum4(nums: IntArray, target: Int): Int {
        val memo = IntArray(target + 1) { -1 }
        memo[0] = 1
        return dfs(memo, nums, target)
    }

    private fun dfs(memo: IntArray, nums: IntArray, remain: Int): Int {
        if (memo[remain] != -1) return memo[remain]

        var count = 0
        for (num in nums) {
            if (remain - num >= 0) {
                count += dfs(memo, nums, remain - num)
            }
        }
        memo[remain] = count
        return count
    }
}
