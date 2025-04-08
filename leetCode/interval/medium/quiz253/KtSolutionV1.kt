package interval.medium.quiz253

import java.util.*

fun main() {
    val intervals = listOf(
        KtSolutionV1.Interval(1, 5),
        KtSolutionV1.Interval(9, 11),
        KtSolutionV1.Interval(3, 10),
        KtSolutionV1.Interval(2, 7),
    )
    KtSolutionV1().minMeetingRooms(intervals).apply {
        println(this)
    }
}

class KtSolutionV1 {

    class Interval(var start: Int, var end: Int)

    fun minMeetingRooms(intervals: List<Interval>): Int {
        intervals.sortedBy { a -> a.start }

        val minHeap = PriorityQueue<Int>()
        for (interval in intervals) {
            if (minHeap.isNotEmpty() && minHeap.peek() <= interval.start) {
                minHeap.poll()
            }
            minHeap.add(interval.end)
        }

        return minHeap.size
    }
}
