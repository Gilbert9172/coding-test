package dynamic.medium.quiz198

import java.util.*

fun main() {
    val solution = KtSolutionV1()
    val nums = intArrayOf(1, 2, 3, 1)
    val answer = solution.rob(nums)
    println(answer)
}

class KtSolutionV1 {
    fun rob(nums: IntArray): Int {

        val memo = IntArray(nums.size) { 0 }
        val s = Stack<Int>()

        var prev = 0
        for (i in nums.indices) {
            memo[i] = maxOf(memo[i], nums[i])

            if (i + 2 < nums.size) {
                for (k in nums.lastIndex downTo i + 2) {
                    s.push(k)
                }
                prev = i
            }


            while (s.isNotEmpty()) {
                val idx = s.pop()
                memo[idx] = maxOf(memo[idx], memo[prev] + nums[idx])
                prev = idx
                if (idx + 2 < nums.size) {
                    for (k in nums.lastIndex downTo idx + 2) {
                        s.push(k)
                    }
                } else {
                    prev = i
                }
            }
        }

        return memo.max()
    }
}
