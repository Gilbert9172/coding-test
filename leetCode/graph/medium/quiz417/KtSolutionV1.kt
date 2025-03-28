package graph.medium.quiz417

fun main() {
    val solution = KtSolutionV1()
    val heights = arrayOf(
        intArrayOf(1, 2, 2, 3, 5),
        intArrayOf(3, 2, 3, 4, 4),
        intArrayOf(2, 4, 5, 3, 1),
        intArrayOf(6, 7, 1, 4, 5)
    )
    val answer = solution.pacificAtlantic(heights)
    answer.forEach {
        print(it.toString())
    }
}

class KtSolutionV1 {

    private var maxRow = 0
    private var maxCol = 0
    private val result = mutableListOf<List<Int>>()
    private val dirs = arrayOf(
        intArrayOf(-1, 0),
        intArrayOf(1, 0),
        intArrayOf(0, -1),
        intArrayOf(0, 1)
    )

    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        maxRow = heights.size
        maxCol = heights[0].size

        for (r in 0 until maxRow) {
            for (c in 0 until maxCol) {
                val (_, pacific, atlantic) = dfs(r, c, heights, mutableSetOf())
                if (pacific && atlantic) {
                    result.add(listOf(r, c))
                }
            }
        }

        return result
    }

    private fun dfs(r: Int, c: Int, heights: Array<IntArray>, visited: MutableSet<String>): BooleanArray {
        val key = "$r:$c"
        if (key in visited) return BooleanArray(3)
        visited.add(key)

        val res = BooleanArray(3) // [visited, pacific, atlantic]

        for (dir in dirs) {
            val nr = r + dir[0]
            val nc = c + dir[1]

            if (nr < 0 || nc < 0) {
                res[1] = true // pacific reachable
            } else if (nr >= maxRow || nc >= maxCol) {
                res[2] = true // atlantic reachable
            } else if (heights[nr][nc] <= heights[r][c]) {
                val (_, pac, atl) = dfs(nr, nc, heights, visited)
                if (pac) res[1] = true
                if (atl) res[2] = true
            }
        }

        res[0] = true
        return res
    }
}

