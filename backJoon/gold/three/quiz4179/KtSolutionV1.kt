package gold.three.quiz4179

fun main() {
    val grid = arrayOf(
        charArrayOf('#', '#', '#', '#'),
        charArrayOf('#', 'J', 'F', '#'),
        charArrayOf('#', '.', '.', '#'),
        charArrayOf('#', '.', '.', '#')
    )
    KtSolutionV1().solve(grid)
}

class KtSolutionV1 {
    data class Point(val x: Int, val y: Int, val time: Int)

    private val dirs = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))

    fun solve(grid: Array<CharArray>) {
        val m = grid.size
        val n = grid[0].size

        val fireTime = Array(m) { IntArray(n) { -1 } }
        val visited = Array(m) { BooleanArray(n) }

        val fireQ = ArrayDeque<Point>()
        val jihoonQ = ArrayDeque<Point>()

        // 불 위치 전부 fireQ에 넣고, fireTime 초기화
        for (r in 0 until m) {
            for (c in 0 until n) {
                if (grid[r][c] == 'F') fireQ.addLast(Point(r, c, 0))
                fireTime[r][c] = 0
            }
        }

        // 지훈이 시작 위치 jihunQ에 넣기
        for (r in 0 until m) {
            for (c in 0 until n) {
                if (grid[r][c] == 'J') jihoonQ.addLast(Point(r, c, 0))
                visited[r][c] = true
            }
        }

        // 1. 불 BFS 먼저 돌려서 fireTime 전부 채우기
        while (fireQ.isNotEmpty()) {
            val (r, c, time) = fireQ.removeFirst()

            for ((x, y) in dirs) {
                val nr = r + x
                val nc = c + y

                if (nr in 0 until m && nc in 0 until n && grid[nr][nc] != '#' && fireTime[nr][nc] == -1) {
                    fireTime[nr][nc] = time + 1
                    fireQ.addLast(Point(nr, nc, time + 1))
                }
            }
        }

        // 2. 지훈이 BFS 돌리면서 가장자리 도달하는지 확인
        while (jihoonQ.isNotEmpty()) {
            val (r, c, time) = jihoonQ.removeFirst()

            if (r == 0 || c == 0 || r == m - 1 || c == n - 1) {
                println(time + 1)
                return
            }

            for ((x, y) in dirs) {
                val nr = r + x
                val nc = c + y

                if (nr in 0 until m && nc in 0 until n && grid[nr][nc] == '.' && !visited[nr][nc]) {
                    if (fireTime[nr][nc] == -1 || fireTime[nr][nc] > time + 1) {
                        visited[nr][nc] = true
                        jihoonQ.addLast(Point(nr, nc, time + 1))
                    }
                }
            }
        }

        println("IMPOSSIBLE")
    }
}
