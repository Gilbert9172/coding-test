package interval.medium.quiz56

/**
 * [57. Insert Interval](https://leetcode.com/problems/insert-interval/description/)
 */
fun main() {
    val intervals = arrayOf(
        intArrayOf(1, 4),
        intArrayOf(0, 4)
    )
    val answer = KtSolutionV1().merge(intervals)
    answer.forEach { println(it.toList().toString()) }
}

class KtSolutionV1 {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy { it[0] }
        val newIntervals = mutableListOf<IntArray>()
        newIntervals.add(intervals[0])
        for (i in 1..intervals.lastIndex) {
            val baseInterval = newIntervals.last()
            val currentInterval = intervals[i]

            if (baseInterval[1] < currentInterval[0]) {
                newIntervals.add(currentInterval)
            } else {
                baseInterval[1] = maxOf(baseInterval[1], currentInterval[1])
            }
        }
        return newIntervals.toTypedArray()
    }
}
