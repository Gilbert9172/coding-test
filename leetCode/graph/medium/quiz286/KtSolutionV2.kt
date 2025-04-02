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
    KtSolutionV2().wallsAndGates(rooms)
    rooms.forEach {
        println(it.toList().toString())
    }
}

class KtSolutionV2 {
    private val dirs = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))

    data class Point(val x: Int, val y: Int, val dist: Int)

    fun wallsAndGates(rooms: Array<IntArray>) {
        val m = rooms.size
        val n = rooms[0].size


        val que = ArrayDeque<Point>()
        for (r in 0 until m) {
            for (c in 0 until n) {
                if (rooms[r][c] == 0) {
                    que.addLast(Point(r, c, 0))
                }
            }
        }

        while (que.isNotEmpty()) {
            val (r, c, dist) = que.removeFirst()
            for ((x, y) in dirs) {
                val nr = r + x
                val nc = c + y

                if ((nr in 0 until m) && (nc in 0 until n) && rooms[nr][nc] == Int.MAX_VALUE) {
                    println("x = $nr, y = $nc")
                    rooms[nr][nc] = dist + 1
                    que.addLast(Point(nr, nc, dist + 1))
                }
            }
        }
    }
}
