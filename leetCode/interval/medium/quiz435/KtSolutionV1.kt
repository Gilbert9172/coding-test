package interval.medium.quiz435

/**
 * [435. Non-overlapping Intervals](https://leetcode.com/problems/non-overlapping-intervals/description/)
 */
fun main() {
    val intervals = arrayOf(
        intArrayOf(-52, 31),
        intArrayOf(-73, -26),
        intArrayOf(82, 97),
        intArrayOf(-65, -11),
        intArrayOf(-62, -49),
        intArrayOf(95, 99),
        intArrayOf(58, 95),
        intArrayOf(-31, 49),
        intArrayOf(66, 98),
        intArrayOf(-63, 2),
        intArrayOf(30, 47),
        intArrayOf(-40, -26)
    )
    KtSolutionV1().eraseOverlapIntervals(intervals).apply {
        println(this)
    }
}

class KtSolutionV1 {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        intervals.sortWith(compareBy({ it[0] }, { it[1] }))

        val newIntervals = mutableListOf<IntArray>()
        var passCount = 0

        for (interval in intervals) {
            if (newIntervals.isEmpty() || newIntervals.last()[1] <= interval[0]) {
                newIntervals.add(interval)
            } else {
                val baseInterval = newIntervals.last()
                baseInterval[0] = maxOf(baseInterval[0], interval[0])
                baseInterval[1] = minOf(baseInterval[1], interval[1])
                passCount++
            }
        }
        return passCount
    }
}
