package dynamic.medium.quiz62

fun main() {
    val solution = KtSolutionV1()
    val answer = solution.uniquePaths(5, 2)
    println(answer)
}

class KtSolutionV1 {

    val dirs = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0))
    private var path = 0

    fun uniquePaths(m: Int, n: Int): Int {
        // Early Return
        if (m == 1 || n == 1) return 1

        // Do dfs logic
        dfs(m, n, 0, 0)

        return path
    }

    private fun dfs(m: Int, n: Int, r: Int, c: Int) {

        if (r == m - 1 && c == n - 1) {
            path++
            return
        }

        for (dir in dirs) {
            val nr = r + dir[0]
            val nc = c + dir[1]

            if (nr >= m || nc >= n) continue

            dfs(m, n, nr, nc)
        }
    }
}

