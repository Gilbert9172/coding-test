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
    val answer = KtSolutionV2().insert(intervals, newInterval)
    answer.forEach { println(it.toList().toString()) }
}

class KtSolutionV2 {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val allIntervals = intervals.toMutableList().apply { add(newInterval) }
        allIntervals.sortBy { it[0] }

        val result = mutableListOf<IntArray>()
        for (interval in allIntervals) {
            if (result.isEmpty() || result.last()[1] < interval[0]) {
                result.add(interval)
            } else {
                result.last()[1] = maxOf(result.last()[1], interval[1])
            }
        }

        return result.toTypedArray()
    }
}
