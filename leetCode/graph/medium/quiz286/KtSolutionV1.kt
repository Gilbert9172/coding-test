package graph.medium.quiz286

/**
 * [286. Walls and Gates](https://leetcode.ca/2016-09-11-286-Walls-and-Gates/)
 */
fun main() {
    val rooms = arrayOf(
        intArrayOf(2147483647, -1, 0, 2147483647),
        intArrayOf(2147483647, 2147483647, 2147483647, -1),
        intArrayOf(2147483647, -1, 2147483647, -1),
        intArrayOf(0, -1, 2147483647, 2147483647),
    )
    KtSolutionV1().wallsAndGates(rooms)
    rooms.forEach {
        println(it.toList().toString())
    }
}

class KtSolutionV1 {
    private val dirs = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))

    data class Point(val x: Int, val y: Int, val dist: Int)

    fun wallsAndGates(rooms: Array<IntArray>) {
        val m = rooms.size
        val n = rooms[0].size

        val startPoints = mutableListOf<Point>()

        for (r in 0 until m) {
            for (c in 0 until n) {
                if (rooms[r][c] == 0) {
                    startPoints += Point(r, c, 0)
                }
            }
        }

        for (startPoint in startPoints) {
            val que = ArrayDeque<Point>()
            que.addLast(startPoint)
            val visited = Array(m) { BooleanArray(n) }

            while (que.isNotEmpty()) {
                val (r, c, dist) = que.removeFirst()
                visited[r][c] = true
                rooms[r][c] = minOf(rooms[r][c], dist)

                for ((x, y) in dirs) {
                    val nr = r + x
                    val nc = c + y

                    if ((nr in 0 until m) && (nc in 0 until n) && rooms[nr][nc] != -1 && !visited[nr][nc]) {
                        println("x = $nr, y = $nc")
                        que.addLast(Point(nr, nc, dist + 1))
                    }
                }
            }
        }
    }
}
