package interval.medium.quiz57

/**
 * [57. Insert Interval](https://leetcode.com/problems/insert-interval/)
 */
fun main() {
    val intervals = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(3, 5),
        intArrayOf(6, 7),
        intArrayOf(8, 10),
        intArrayOf(12, 16),
    )
    val newInterval = intArrayOf(4, 8)
    val answer = KtSolutionV1().insert(intervals, newInterval)
    answer.forEach { println(it.toList().toString()) }
}

class KtSolutionV1 {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {

        val newIntervals = mutableListOf<IntArray>()

        var idx = 0
        while (idx < intervals.size && intervals[idx][1] < newInterval[0]) {
            newIntervals.add(intervals[idx])
            idx++
        }

        while (idx < intervals.size && intervals[idx][0] <= newInterval[1]) {
            newInterval[0] = minOf(newInterval[0], intervals[idx][0])
            newInterval[1] = maxOf(newInterval[1], intervals[idx][1])
            idx++
        }

        newIntervals.add(newInterval)

        while (idx < intervals.size) {
            newIntervals.add(intervals[idx])
            idx++
        }

        return newIntervals.toTypedArray()
    }
}
