package bit.easy.quiz268

fun main() {
    val array = intArrayOf(0, 1)
    val solution = KtSolutionV1()
    println(solution.missingNumber(array))
}

/**
 * [268. Missing Number](https://leetcode.com/problems/missing-number/description/)
 */
class KtSolutionV1 {
    fun missingNumber(nums: IntArray): Int {
        val map: MutableMap<Int, Boolean> = mutableMapOf()
        for (num in nums) {
            map[num] = true
        }

        for (i in 0..nums.size) {
            if (!map.containsKey(i)) {
                return i
            }
        }

        return 0
    }
}
