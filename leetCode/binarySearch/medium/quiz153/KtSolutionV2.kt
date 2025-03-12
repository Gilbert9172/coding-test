package binarySearch.medium.quiz153

fun main() {

    val solution = KtSolutionV2()
    val nums = intArrayOf(7, 0, 1, 2, 3, 4, 5, 6)
    val answer = solution.findMin(nums)
    println(answer)
}

/**
 * [153. Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/)
 *
 * ⏰Runtime : 0 ms
 *
 * > Constraints
 *
 * - 시간복잡도 : N(logN)
 *
 * - 중복된 요소는 없다.
 *
 * - 1 <= n <= 5000
 *
 * - -5000 <= element <= 5000
 *
 * > Approach & Flow
 *
 * 해당 풀이의 경우 left의 비교 대상이 right, mid 임.
 *
 * 여기서는 아래의 조건을 잘 확인해야 함.
 *
 * `nums[left] <= nums[mid]` 경우는 left가 mid 보다 작기 때문에,
 *
 * 더이상 left ~ mid 범위를 더 탐색할 필요 없음. 따라서 left를 `mid + 1`로 이동
 *
 * `nums[left] > nums[mid]` 경우는 left가 mid 보다 크기 때문에,
 *
 * > Example
 *
 * nums = 7, 0, 1, 2, 3, 4, 5, 6
 *
 * left = 0
 *
 * right = 7
 *
 * mid = 3
 *
 * 다음 경우 성립 : `nums[left] > nums[mid]`
 *
 * 이 뜻은 `mid ~ right` 범위 내 모든 값은 left 값보다 작음.
 *
 * `mid + 1 ~ right` 범위에 있는 값은 mid 보다 크고 left 보다 작기 때문에 후보가 될 수 없음.
 *
 * 즉 `left ~ mid - 1`에 정답 후보가 있음.
 */


class KtSolutionV2 {
    fun findMin(nums: IntArray): Int {
        var left = 0
        var right = nums.lastIndex

        var ans = Int.MAX_VALUE

        while (left <= right) {
            val mid = left + (right - left) / 2
            if (nums[left] <= nums[right]) {
                ans = minOf(ans, nums[left])
            }
            if (nums[left] <= nums[mid]) {
                ans = minOf(ans, nums[left])
                left = mid + 1
            } else {
                ans = minOf(ans, nums[mid])
                right = mid - 1
            }
        }
        return ans
    }
}
