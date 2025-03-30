package graph.medium.quiz207

/**
 * [207. Course Schedule](https://leetcode.com/problems/course-schedule/)
 */
fun main() {
    val solution = KtSolutionV1()
    val prerequisites = arrayOf(
        intArrayOf(1, 4),
        intArrayOf(2, 4),
        intArrayOf(3, 1),
        intArrayOf(3, 2),
        intArrayOf(4, 5)
    )
    val answer = solution.canFinish(5, prerequisites)
    println(answer)
}

class KtSolutionV1 {

    private val taken = mutableSetOf<Int>()
    private val takes = mutableSetOf<Int>()

    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {

        // 인접 리스트를 생성한다.
        val courseRelationMap = mutableMapOf<Int, MutableList<Int>>()
        for (prerequisite in prerequisites) {
            courseRelationMap.putIfAbsent(prerequisite[0], mutableListOf())
            courseRelationMap[prerequisite[0]]!!.add(prerequisite[1])
        }

        for (course in courseRelationMap.keys) {
            if (!dfs(courseRelationMap, course)) return false
        }
        return true
    }

    private fun dfs(
        courseRelationMap: MutableMap<Int, MutableList<Int>>,
        course: Int
    ): Boolean {
        when {
            takes.contains(course) -> return false
            taken.contains(course) -> return true
        }

        if (courseRelationMap.containsKey(course)) {
            takes.add(course)
            for (take in courseRelationMap[course]!!) {
                if (!dfs(courseRelationMap, take)) return false
            }
            markAsFinished(course)
        }
        return true
    }

    private fun markAsFinished(course: Int) {
        takes.remove(course)
        taken.add(course)
    }
}
