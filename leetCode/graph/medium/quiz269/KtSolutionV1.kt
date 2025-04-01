package graph.medium.quiz269

import java.util.*

/**
 * [269. Alien Dictionary](https://leetcode.ca/2016-08-25-269-Alien-Dictionary/)
 */
fun main() {
    val words = arrayOf("wrt", "wrf", "er", "ett", "rftt")
    val answer = KtSolutionV1().alienDictionary(words)
    println(answer)
}

class KtSolutionV1 {
    fun alienDictionary(words: Array<String>): String {
        val graph = mutableMapOf<Char, MutableList<Char>>()
        val degrees = mutableMapOf<Char, Int>()

        // 1. 모든 문자를 노드로 등록
        for (word in words) {
            for (c in word) {
                graph.putIfAbsent(c, mutableListOf())
                degrees.putIfAbsent(c, 0)
            }
        }

        // 2. 문자 간 관계 찾기
        for (i in 0 until words.lastIndex) {
            val first = words[i]
            val second = words[i + 1]
            val minLen = minOf(first.length, second.length)

            // invalid case: ["abc", "ab"]처럼 앞 단어가 더 긴 경우는 잘못된 순서
            if (first.startsWith(second) && first.length > second.length) return ""

            for (k in 0 until minLen) {
                if (first[k] != second[k]) {
                    val from = first[k]
                    val to = second[k]
                    if (to !in graph[from]!!) {
                        graph[from]!!.add(to)
                        degrees[to] = degrees[to]!! + 1
                    }
                    break
                }
            }
        }

        // 3. 진입 차수 0인 문자들 큐에 추가
        val q = LinkedList<Char>()
        val result = StringBuilder()

        for ((char, degree) in degrees) {
            if (degree == 0) q.offer(char)
        }

        // 4. 위상 정렬 수행
        while (q.isNotEmpty()) {
            val current = q.poll()
            result.append(current)

            for (neighbor in graph[current] ?: emptySet()) {
                degrees[neighbor] = degrees[neighbor]!! - 1
                if (degrees[current] == 0) {
                    q.offer(neighbor)
                }
            }
        }

        return if (result.length == degrees.size) result.toString() else ""
    }
}
