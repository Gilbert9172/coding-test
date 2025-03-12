package binarySearch.medium.quiz33

fun main() {
    val solution = KtSolutionV2()

    val nums = intArrayOf(4, 5, 6, 7, 0, 1, 2)
    val target = 0

    val answer = solution.search(nums, target)
    println(answer)
}

/**
 * [33. Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/description/)
 *
 * ✅Duration : 20min 53sec
 *
 * ⏰Runtime : 10 ms
 *
 * > Constraints
 *
 * - 시간복잡도 : N(logN)
 *
 * - 1 <= nums.length <= 5000
 *
 * - -10^4 <= element <= 10^4
 *
 * > Approach & Flow
 *
 * Binary Search를 이용해서 pivot 탐색
 *
 * 최악의 경우에도 N(logN)의 시간복잡도를 유지해야 하기 때문에 Binary Search 수행
 *
 * 두 개의 정렬된 subarray 중 왼쪽을 우선 탐색
 *
 * 왼쪽에서 탐색을 성공적으로 하지 못했을 경우 오른쪽 탐색 시작
 *
 */

class KtSolutionV2 {
    fun search(nums: IntArray, target: Int): Int {
        val pivotIdx = findPivotIdx(nums)
        val leftSearch = doBinarySearch(0, pivotIdx - 1, nums, target)

        return if (leftSearch >= 0) {
            leftSearch
        } else {
            doBinarySearch(pivotIdx, nums.lastIndex, nums, target)
        }
    }

    private fun findPivotIdx(nums: IntArray): Int {
        var left = 0
        var right = nums.lastIndex

        while (left <= right) {
            val mid = left + (right - left) / 2
            if (mid > 0 && nums[mid - 1] > nums[mid]) {
                return mid
            } else if (nums[0] <= nums[mid]) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return 0
    }

    private fun doBinarySearch(left: Int, right: Int, nums: IntArray, target: Int): Int {
        var mLeft = left
        var mRight = right

        while (mLeft <= mRight) {
            val mid = mLeft + (mRight - mLeft) / 2
            val center = nums[mid]
            if (center < target) {
                mLeft = mid + 1
            } else if (target < center) {
                mRight = mid - 1
            } else {
                return mid
            }
        }
        return -1
    }
}
