package dynamic.medium.quiz300

fun main() {
    val solution = KtSolutionV3()
    val nums = intArrayOf(10, 9, 2, 5, 3, 7, 101, 18)
    val answer = solution.lengthOfLIS(nums)
    println(answer)
}

class KtSolutionV3 {
    fun lengthOfLIS(nums: IntArray): Int {
        val subSeq = mutableListOf<Int>()

        for (num in nums) {
            if (subSeq.isEmpty() || subSeq.last() < num) {
                subSeq.add(num)
            } else {
                val idx = binarySearch(subSeq, num)
                subSeq[idx] = num
            }
        }

        return subSeq.size
    }

    private fun binarySearch(subSeq: List<Int>, target: Int): Int {
        var left = 0
        var right = subSeq.lastIndex

        while (left <= right) {
            val mid = left + (right - left) / 2
            when {
                subSeq[mid] == target -> return mid
                subSeq[mid] > target -> right = mid - 1
                else -> left = mid + 1
            }
        }

        return left
    }
}
