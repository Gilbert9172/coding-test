package graph.medium.quiz210

/**
 * [210. Course Schedule II](https://leetcode.com/problems/course-schedule-ii/description/)
 */
fun main() {
    val prerequisites = arrayOf(
        intArrayOf(1, 0),
        intArrayOf(2, 0),
        intArrayOf(3, 1),
        intArrayOf(3, 2)
    )
    KtSolutionV1().findOrder(2, arrayOf()).apply {
        println(this.toList().toString())
    }

}

class KtSolutionV1 {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {

        val degrees = IntArray(numCourses)
        val courses = mutableListOf<MutableList<Int>>()
        for (i in 0 until numCourses) {
            courses.add(mutableListOf())
        }

        for (i in prerequisites.indices) {
            degrees[prerequisites[i][0]]++
            courses[prerequisites[i][1]].add(prerequisites[i][0])
        }

        val que = ArrayDeque<Int>()
        degrees.forEachIndexed { idx, degree -> if (degree == 0) que.addLast(idx) }

        val courseTakeOrder = IntArray(numCourses)
        var idx = 0

        while (que.isNotEmpty()) {
            val pre = que.removeFirst()
            courseTakeOrder[idx] = pre
            idx++

            for (main in courses[pre]) {
                if (--degrees[main] == 0) {
                    que.addLast(main)
                }
            }
        }

        return if (idx == numCourses) courseTakeOrder else intArrayOf()
    }
}
