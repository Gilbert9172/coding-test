package dynamic.medium.quiz152

import kotlin.math.max
import kotlin.math.min

fun main() {
    val nums = intArrayOf(-3, 0, 1, -2)
    println(maxProductV3(nums))
}

fun maxProductV3(nums: IntArray): Int {
    var min = nums[0]
    var max = nums[0]

    var res = min

    for (i in 1..nums.lastIndex) {
        val tempMin = min * nums[i]
        val tempMax = max * nums[i]
        when {
            nums[i] == 0 -> {
                res = max(res, 0)
                min = 0
                max = 0
            }

            nums[i] < 0 -> {
                max = max(tempMin, nums[i])
                min = min(tempMax, nums[i])
            }

            nums[i] > 0 -> {
                min = min(tempMin, nums[i])
                max = max(tempMax, nums[i])
            }
        }
        res = max(res, max)
    }
    return res
}
