package binarySearch.medium.quiz153

fun main() {
    val solution = KtSolutionV1()

    val nums = intArrayOf(11, 13, 15, 17)
    val answer = solution.findMin(nums)
    println(answer)
}

/**
 * [153. Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/)
 *
 * ✅Duration : 11min 25sec
 *
 * ⏰Runtime : 10 ms
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
 * 배열의 n번의 회전으로 인해 정렬이 흐트러짐.
 *
 * pivot을 기준으로 좌우 subarray는 오름차순으로 정렬된 상태
 *
 * 주어진 배열의 마지막 값(lastEle)을 기준으로 pivot을 구함. 이때 pivot은 무조건 제일 작은 수
 *
 * `nums[mid]가 lastEle 보다 작다`는 말은 `nums[mid] 포함 왼쪽에 가장 작은 요소가 위치함`
 *
 * `nums[mid]가 lastEle 보다 크다`는 말은 `nums[mid] 포함 오른쪽에 가장 작은 요소가 위치함`
 *
 * 그리고 while 문의 조건을 `left < right` 라고 작성한 이유는
 *
 * nums[mid]와 비교하는 대상이 특정 target이 아닌, `마지막 요소`이기 때문임. 아니면 무한 루프에 걸림
 *
 * > 무한 루프 예시
 *
 * 예를 들어 주어진 배열이 다음과 같을 때 (4,5,6,7,0,1,2)
 *
 * left = 4, right = 4
 *
 * mid = 4
 *
 * `nums[mid] < lastEle` 는 항상 참
 *
 * right = mid = 4 (무한 루프 발생)
 */

class KtSolutionV1 {
    fun findMin(nums: IntArray): Int {

        val lastEle = nums[nums.lastIndex]

        var left = 0
        var right = nums.lastIndex

        while (left < right) {
            val mid = left + (right - left) / 2

            if (nums[mid] < lastEle) {
                right = mid
            } else if (nums[mid] > lastEle) {
                left = mid + 1
            }
        }

        return nums[left]
    }
}
