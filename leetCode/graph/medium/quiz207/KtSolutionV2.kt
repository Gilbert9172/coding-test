package graph.medium.quiz207

import java.util.*

/**
 * [207. Course Schedule](https://leetcode.com/problems/course-schedule/)
 */
fun main() {
    val solution = KtSolutionV2()
    val prerequisites = arrayOf(
        intArrayOf(1, 0),
        intArrayOf(1, 2),
        intArrayOf(3, 1),
        intArrayOf(2, 3),
        intArrayOf(2, 4),
        intArrayOf(4, 5),
        intArrayOf(2, 5)
    )
    val answer = solution.canFinish(7, prerequisites)
    println(answer)
}

class KtSolutionV2 {

    private val courses = mutableListOf<MutableList<Int>>()
    private lateinit var degrees: IntArray
    private lateinit var queue: LinkedList<Int>

    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {

        // 1. Degree 배열 초기화 & 선행 수강 목록 초기화
        initiateCoursesAndDegree(numCourses, prerequisites)

        // 2. 위상정렬 로직을 위한 Queue 초기화
        initiateQueue()

        // 3. 위상정렬 로직 실행
        val result = mainLogic()

        return result == numCourses
    }

    private fun initiateCoursesAndDegree(numCourses: Int, prerequisites: Array<IntArray>) {
        // 빈 리스트로 수강목록 초기화
        for (i in 0..<numCourses) courses.add(mutableListOf())

        // 진입차수 선언 (크기: numCourses)
        degrees = IntArray(numCourses)

        // ⚠️ 주의: prerequisites 인덱스를 순회해야 함.
        for (i in prerequisites.indices) {
            // 진입 차수 증가
            degrees[prerequisites[i][0]]++
            // 선행되어야 할 수강목록 갱신
            courses[prerequisites[i][1]].add(prerequisites[i][0])
        }
    }

    private fun initiateQueue() {
        // 위상정렬 로직을 위한 Queue 선언
        queue = LinkedList<Int>()

        // 진입 차수가 0인 수강을 Q에 offer
        degrees.forEachIndexed { idx, degree ->
            if (degree == 0) queue.offer(idx)
        }
    }

    private fun mainLogic(): Int {
        var takenCourse = 0
        while (!queue.isEmpty()) {

            val preCourse = queue.poll()
            takenCourse++

            for (course in courses[preCourse]) {
                // 진입 차수가 0이 된 경우 Q에 offer : 해당 노드에 대한 모든 선행 조건이 이미 충족되었다는 뜻
                if (--degrees[course] == 0) {
                    queue.offer(course)
                }
            }
        }
        return takenCourse
    }
}
