package graph.medium.quiz417

fun main() {
    val solution = KtSolutionV2()
    val heights = arrayOf(
        intArrayOf(1, 2, 2, 3, 5),
        intArrayOf(3, 2, 3, 4, 4),
        intArrayOf(2, 4, 5, 3, 1),
        intArrayOf(6, 7, 1, 4, 5),
        intArrayOf(5, 1, 1, 2, 4)
    )
    val answer = solution.pacificAtlantic(heights)
    answer.forEach {
        print(it.toString())
    }
}

class KtSolutionV2 {
    private val dirs = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))
    private var m = 0
    private var n = 0

    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        m = heights.size
        n = heights[0].size

        val pacific = Array(m) { BooleanArray(n) }
        val atlantic = Array(m) { BooleanArray(n) }

        // row만 이동, col은 고정
        for (i in 0 until m) {
            dfs(i, 0, heights, pacific)
            dfs(i, n - 1, heights, atlantic)
        }

        // row는 고정, col만 이동
        for (j in 0 until n) {
            dfs(0, j, heights, pacific)
            dfs(m - 1, j, heights, atlantic)
        }

        val result = mutableListOf<List<Int>>()
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(listOf(i, j))
                }
            }
        }

        return result
    }

    private fun dfs(r: Int, c: Int, heights: Array<IntArray>, visited: Array<BooleanArray>) {
        visited[r][c] = true
        for (dir in dirs) {
            val nr = r + dir[0]
            val nc = c + dir[1]

            if (nr in 0 until m && nc in 0 until n && !visited[nr][nc] && heights[nr][nc] >= heights[r][c]) {
                dfs(nr, nc, heights, visited)
            }
        }
    }
}

