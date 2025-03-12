package binarySearch.medium.quiz33

fun main() {
    val solution = KtSolutionV3()

    val nums = intArrayOf(4, 5, 6, 7, 0, 1, 2)
    val target = 6

    val answer = solution.search(nums, target)
    println(answer)
}

/**
 * [33. Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/description/)
 *
 * ⏰Runtime : 0 ms
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
 * Binary Search를 이용해서 효율적으로 pivot index 탐색
 *
 * 이 때 주어진 배열의 `마지막 요소(lastEle)는 고정`
 *
 * `왜냐면 pivot 이후의 값 들은 항상 lastEle 보다 작거나 같기 때문.`
 *
 * 최악의 경우에도 N(logN)의 시간복잡도를 유지해야 하기 때문에 Binary Search 수행
 *
 * `타겟 값이 lastEl 보다 작다`는 것은 pivot을 기준으로 `오른쪽을 탐색`하라는 의미
 *
 * `타겟 값이 lastEl 보다 크다`는 것은 pivot을 기준으로 `왼쪽을 탐색`하라는 의미
 *
 */

class KtSolutionV3 {

    fun search(nums: IntArray, target: Int): Int {
        val lastEl = nums[nums.lastIndex]
        val pivotIdx = findPivotIdx(nums, lastEl)

        return if (target <= lastEl) {
            doBinarySearch(nums, pivotIdx, nums.size - 1, target)
        } else {
            doBinarySearch(nums, 0, pivotIdx - 1, target)
        }
    }

    private fun findPivotIdx(nums: IntArray, lastEle: Int): Int {
        var start = 0
        var end = nums.lastIndex

        while (start < end) {
            val mid = start + (end - start) / 2
            if (nums[mid] <= lastEle) {
                end = mid
            } else {
                start = mid + 1
            }
        }
        return start
    }

    private fun doBinarySearch(nums: IntArray, start: Int, end: Int, target: Int): Int {
        var mStart = start
        var mEnd = end

        while (mStart <= mEnd) {
            val mid = (mEnd - mStart) / 2 + mStart
            if (nums[mid] < target) {
                mStart = mid + 1
            } else if (nums[mid] > target) {
                mEnd = mid - 1
            } else return mid
        }

        return -1
    }
}
