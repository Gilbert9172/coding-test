package dynamic.medium.quiz377

fun main() {
    val solution = KtSolutionV1()
    val nums = intArrayOf(1, 2, 3)
    val target = 4
    val answer = solution.combinationSum4(nums, target)
    println(answer)
}

class KtSolutionV1 {
    fun combinationSum4(nums: IntArray, target: Int): Int {
        val memo = IntArray(target + 1) { 0 }
        memo[0] = 1

        for (i in 1..target) {
            for (num in nums) {
                if (i - num >= 0) {
                    memo[i] += memo[i - num]
                }
            }
        }

        return memo[target]
    }
}
