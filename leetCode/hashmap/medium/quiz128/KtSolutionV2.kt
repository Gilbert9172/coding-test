package hashmap.medium.quiz128

fun main() {
    val nums = intArrayOf(100, 4, 200, 1, 3, 2)
    val answer = KtSolutionV2().longestConsecutive(nums)
    println(answer)
}

/**
 * for문과 while 문이 중첩되어 있어, O(n²)의 시작 복잡도를 가지는 것 처럼 보이지만,
 *
 * 숫자마다 최대 한 번만 while에서 탐색되며 중복 탐색이 없다.
 *
 * 따라서 O(n)의 시간 복잡도를 갖는다고 말할 수 있다.
 *
 * 또한 Set을 사용해서 포함 여부를 O(1)에 확인할 수 있다
 */
class KtSolutionV2 {
    fun longestConsecutive(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        val numSet = nums.toMutableSet()

        var maxLen = 0
        for (num in numSet) {
            if (!numSet.contains(num - 1)) { // num - 1을 시작 지점으로 한다.
                var currNum = num
                var currLen = 1
                while (numSet.contains(currNum + 1)) {
                    currLen++
                    currNum++
                }
                maxLen = maxOf(maxLen, currLen)
            }
        }

        return maxLen
    }
}
