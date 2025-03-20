package greedy.medium.quiz11

fun main() {
    val nums = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)
    val solution = KtSolutionV1()
    println(solution.maxArea(nums))
}

/**
 *
 * 📄[11. Container With Most Water](https://leetcode.com/problems/container-with-most-water/description/)
 *
 * ✅Duration : 20min 50sec
 *
 * ⏰Runtime : 7 ms
 *
 */
class KtSolutionV1 {

    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var maxArea = 0

        while (left < right) {

            val currentArea = calculateCurrentArea(left, right, height)
            maxArea = maxOf(maxArea, currentArea)
            when {
                height[left] >= height[right] -> right--
                else -> left++
            }
        }
        return maxArea
    }

    private fun calculateCurrentArea(
        left: Int,
        right: Int,
        height: IntArray
    ): Int = (right - left) * minOf(height[left], height[right])
}
