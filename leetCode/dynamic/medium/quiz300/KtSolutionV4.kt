package dynamic.medium.quiz300

fun main() {
    val solution = KtSolutionV4()
    val nums = intArrayOf(10, 9, 2, 5, 3, 7, 101, 18)
    val answer = solution.lengthOfLIS(nums)
    println(answer)
}

class KtSolutionV4 {
    fun lengthOfLIS(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        val subSeq = IntArray(nums.size)
        var size = 0

        for (num in nums) {
            var left = 0
            var right = size

            while (left < right) {
                val mid = left + (right - left) / 2
                when {
                    subSeq[mid] < num -> left = mid + 1
                    else -> right = mid
                }
            }

            subSeq[left] = num

            // subSeq 마지막에 요소를 삽압했을 경우 size 갱신
            if (left == size) size++
        }

        return size
    }
}
