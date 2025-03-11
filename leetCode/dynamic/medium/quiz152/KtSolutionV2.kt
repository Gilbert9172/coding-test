package dynamic.medium.quiz152

import kotlin.math.max

fun main() {
    val nums = intArrayOf(-3, 0, 1, 5, -4, -7, 1, -2)
    println(maxProductV2(nums))
}

fun maxProductV2(nums: IntArray): Int {

    val n = nums.size
    var left = 1
    var right = 1
    var answer = nums[0]

    for (i in nums.indices) {
        left = if (left == 0) 1 else left
        right = if (right == 0) 1 else right

        left *= nums[i]
        right *= nums[n - i - 1]

        answer = max(answer, max(left, right))
    }

    return answer
}
