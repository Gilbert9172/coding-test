package dynamic.medium.quiz152

import kotlin.math.max
import kotlin.math.min

fun main() {
    val nums = intArrayOf(-3, 0, 1, 5, -4, -7, 1, -2)
    println(maxProduct(nums))
}

fun maxProduct(nums: IntArray): Int {

    if (nums.isEmpty()) return 0

    // 이전 결과를 저장
    var maxProduct = nums[0]
    var minProduct = nums[0]

    var result = nums[0]

    for (i in 1..nums.lastIndex) {
        val num = nums[i]

        // 최댓값과 최솟값 swap
        if (num < 0) {
            val temp = maxProduct
            maxProduct = minProduct
            minProduct = temp
        }

        maxProduct = max(num, maxProduct * num)
        minProduct = min(num, minProduct * num)

        result = max(result, maxProduct)
    }

    return result
}
