package binarySearch.medium.quiz33

fun main() {
    val solution = KtSolutionV1()

    val nums = intArrayOf(4, 5, 6, 7, 0, 1, 2)
    val target = 3

    val answer = solution.search(nums, target)
    println(answer)
}

/**
 * [33. Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/description/)
 *
 * ✅Duration : 20min 53sec
 *
 * ⏰Runtime : 19 ms
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
 * 피봇을 기준으로 정렬이 흐트러져 있음.
 *
 * 따라서 피봇을 기준으로 두 개의 정렬된 subarray 추출
 *
 * 최악의 경우에도 N(logN)의 시간복잡도를 유지해야 하기 때문에 Binary Search 수행
 *
 * 두 개의 정렬된 subarray 중 왼쪽을 우선 탐색
 *
 * 왼쪽에서 탐색을 성공적으로 하지 못했을 경우 오른쪽 탐색 시작
 *
 * 최초 인덱스를 유지하기 위해서 오른쪽 결과 값이 -1이 아닌 경우에는 (pivot + 1) 더하기 연산 추가
 *
 */

class KtSolutionV1 {

    fun search(nums: IntArray, target: Int): Int {
        val pivotIdx = findPivotIdx(nums)
        val asList = nums.asList()

        val leftSub = asList.subList(0, pivotIdx + 1)
        val rightSub = asList.subList(pivotIdx + 1, nums.lastIndex + 1)

        val leftResult = doBinarySearch(leftSub, target)
        if (leftResult >= 0) {
            return leftResult
        }

        val rightResult = doBinarySearch(rightSub, target)
        return if (rightResult >= 0) rightResult + pivotIdx + 1 else -1
    }

    private fun doBinarySearch(subList: List<Int>, target: Int): Int {
        var left = 0
        var right = subList.lastIndex

        while (left <= right) {
            val mid = left + (right - left) / 2
            if (target > subList[mid]) {
                left = mid + 1
            } else if (target < subList[mid]) {
                right = mid - 1
            } else {
                return mid
            }
        }
        return -1
    }

    private fun findPivotIdx(nums: IntArray): Int {
        var pivotIdx = 0
        for (i in 1..nums.lastIndex) {
            if (nums[i - 1] > nums[i]) {
                pivotIdx = i - 1
            }
        }
        return pivotIdx
    }
}
