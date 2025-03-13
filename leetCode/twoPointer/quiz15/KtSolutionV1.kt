package twoPointer.quiz15

fun main() {
    val solution = KtSolutionV1()

    val nums = intArrayOf(-1, 0, 1, 2, -1, -4)
    solution.threeSum(nums)

    println(solution)
}


/**
 * [15. 3Sum](https://leetcode.com/problems/3sum/description/)
 *
 * ✅Duration : 22min 24sec
 *
 * ⏰Runtime : 55 ms
 *
 */

class KtSolutionV1 {

    private val candidates: MutableSet<List<Int>> = mutableSetOf()
    private lateinit var localNums: IntArray

    fun threeSum(nums: IntArray): List<List<Int>> {
        localNums = nums

        localNums.sort()

        for (i in 0..<localNums.lastIndex) {
            if (i > 0 && localNums[i - 1] == localNums[i]) continue;
            findCandidates(i, i + 1, localNums.lastIndex)
        }

        return candidates.toList()
    }

    private fun findCandidates(
        current: Int,
        left: Int,
        right: Int
    ) {
        var mLeft = left
        var mRight = right
        var total: Int

        while (mLeft < mRight) {
            total = localNums[current] + localNums[mLeft] + localNums[mRight]
            when {
                total < 0 -> mLeft++
                total > 0 -> mRight--
                else -> {
                    createCandidateAndUpdate(current, mLeft, mRight)

                    while (mLeft < mRight && localNums[mLeft] == localNums[mLeft + 1]) {
                        mLeft++
                    }

                    while (mLeft < mRight && localNums[mRight] == localNums[mRight - 1]) {
                        mRight--
                    }

                    mLeft++
                    mRight--
                }
            }
        }
    }

    private fun createCandidateAndUpdate(current: Int, left: Int, right: Int) {
        val candidate = listOf(localNums[current], localNums[left], localNums[right])
        candidates.add(candidate)
    }
}
