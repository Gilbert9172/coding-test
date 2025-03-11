package array.medium.quiz53

import kotlin.math.max

fun main() {
    val nums = intArrayOf(1, -2, 3, 5, -4, 2, 5)
    println(optimizedKadane(nums))
}

// Dynamic Programming
fun optimizedKadane(nums: IntArray): Int {
    var result = Int.MIN_VALUE
    var sum = 0

    for (num in nums) {
        sum += num
        result = max(sum, result)

        // sum < 0 이면 지금까지 기록은 리셋한다.
        if (sum < 0) sum = 0
    }

    return result
}

// Dynamic Programming
fun kadaneAlgorithm(nums: IntArray): Int {
    var result = nums[0]
    var maxEnding = nums[0]

    for (i in 1..nums.lastIndex step (1)) {
        maxEnding = max(maxEnding + nums[i], nums[i])
        result = max(maxEnding, result)
    }

    return result
}

// Time Limit Exceed
fun bruteForce(nums: IntArray): Int {

    val list = nums.toList()

    var fix = 0
    var move = 1
    var maxSum = Int.MIN_VALUE

    while (fix <= nums.lastIndex) {
        val subSum = list.subList(fix, move).sum()
        maxSum = maxOf(maxSum, subSum)
        if (move > nums.lastIndex) {
            fix++
            move = fix + 1
        } else {
            move++
        }
    }

    return maxSum
}
