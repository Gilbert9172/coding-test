package interval.easy.quiz252

/**
 * [252. Meeting Rooms](https://neetcode.io/problems/meeting-schedule)
 */
fun main() {
    val intervals = arrayOf(
        intArrayOf(5, 8),
        intArrayOf(9, 15)
    )
    KtSolutionV2().canAttendMeetings(intervals).apply {
        println(this)
    }
}


class KtSolutionV2 {
    fun canAttendMeetings(intervals: Array<IntArray>): Boolean {
        intervals.sortBy { it[0] }

        var prevEnd = intervals[0][1]

        for (i in 1..intervals.lastIndex) {
            val (start, end) = intervals[i]
            if (start < prevEnd) return false
            prevEnd = end
        }

        return true
    }
}
