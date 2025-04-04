package interval.medium.quiz435

/**
 * [435. Non-overlapping Intervals](https://leetcode.com/problems/non-overlapping-intervals/description/)
 */
fun main() {
    val intervals = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(2, 3),
        intArrayOf(3, 4),
        intArrayOf(1, 3)
    )
    KtSolutionV2().eraseOverlapIntervals(intervals).apply {
        println(this)
    }
}

class KtSolutionV2 {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        if (intervals.isEmpty()) return 0

        intervals.sortBy { it[1] }

        var passCount = 0
        var prevEnd = intervals[0][1]

        for (i in 1..intervals.lastIndex) {
            val (start, end) = intervals[i]
            if (start < prevEnd) {
                // prevEnd 보다 시작점이 작으면 겹침으로 간주 → passCount 증가
                passCount++
            } else {
                // 겹치지 않으면 → prevEnd 갱신
                prevEnd = end
            }
        }

        return passCount
    }
}
