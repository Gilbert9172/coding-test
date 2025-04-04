package interval.easy.quiz252

/**
 * [252. Meeting Rooms](https://neetcode.io/problems/meeting-schedule)
 */
fun main() {
    val intervals = arrayOf(
        intArrayOf(5, 8),
        intArrayOf(9, 15)
    )
    KtSolutionV1().canAttendMeetings(intervals).apply {
        println(this)
    }
}

class KtSolutionV1 {
    fun canAttendMeetings(intervals: Array<IntArray>): Boolean {
        if (intervals.isEmpty()) return true
        intervals.sortBy { it[0] }

        val baseInterval = intArrayOf(intervals[0][0], intervals[0][1])

        for (i in 1..intervals.lastIndex) {
            val (start, end) = intervals[i]
            if (start < baseInterval[1]) {
                return false
            } else {
                baseInterval[0] = start
                baseInterval[1] = end
            }
        }

        return true
    }
}

