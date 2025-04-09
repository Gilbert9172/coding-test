package interval.hard.quiz1851

import java.util.*

// Input: intervals = [[1,4],[2,4],[3,6],[4,4]], queries = [2,3,4,5]
fun main() {
    val intervals = arrayOf(
        intArrayOf(1, 4),
        intArrayOf(2, 4),
        intArrayOf(3, 6),
        intArrayOf(4, 4)
    )
    val queries = intArrayOf(2, 3, 4, 5)
    KtSolutionV1().minInterval(intervals, queries)
        .toList()
        .toString().apply {
            println(this)
        }
}

class KtSolutionV1 {

    fun minInterval(intervals: Array<IntArray>, queries: IntArray): IntArray {
        intervals.sortBy { it[0] }

        val result = IntArray(queries.size) { -1 }

        val pq = PriorityQueue<IntArray>(compareBy { it[0] })

        val indexQueries = queries.withIndex().sortedBy { it.value }

        var i = 0
        for ((idx, query) in indexQueries) {
            while (i < intervals.size && intervals[i][0] <= query) {
                val (start, end) = intervals[i]
                val size = end - start + 1
                pq.offer(intArrayOf(size, end))
                i++
            }

            while (pq.isNotEmpty() && pq.peek()[1] < query) {
                pq.poll()
            }

            if (pq.isNotEmpty()) {
                result[idx] = pq.peek()[0]
            }
        }
        return result
    }
}
