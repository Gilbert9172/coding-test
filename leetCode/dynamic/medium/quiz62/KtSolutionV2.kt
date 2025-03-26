package dynamic.medium.quiz62

fun main() {
    val solution = KtSolutionV2()
    val answer = solution.uniquePaths(51, 9)
    println(answer)
}

class KtSolutionV2 {

    private var maxRow = 0
    private var maxCol = 0
    private val dirs = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0))

    fun uniquePaths(m: Int, n: Int): Int {
        maxRow = m; maxCol = n

        // 조기 종료 조건
        if (maxRow == 1 || maxCol == 1) return 1

        // 2차원 memo 배열 초기화
        // 무조건 F에 도달하는 문제이기 때문에 마지막 포인트는 1로 초기화
        val memo = Array(maxRow) { IntArray(maxCol) }
        memo[0][0] = 0
        memo[maxRow - 1][maxCol - 1] = 1

        // 결과 반환
        return dfs(0, 0, memo)
    }

    private fun dfs(r: Int, c: Int, memo: Array<IntArray>): Int {
        // dfs 탈출 조건
        // 1. 마지막 포인트에 도달한 경우
        // 2. 현재 포인트에서 경우의 수를 갱신한 기록이 있는 경우
        when {
            r == maxRow - 1 && c == maxCol - 1 -> return memo[r][c]
            memo[r][c] != 0 -> return memo[r][c]
        }

        // 이동 가능한 범위 순회
        for (dir in dirs) {
            val nr = r + dir[0]
            val nc = c + dir[1]

            // 지형을 벗어난 경우 건너뜀
            if (nr >= maxRow || nc >= maxCol) continue

            // dfs 결과 값을 현재 포인트에 던한 값을 현재 포인트 (r,c)에 갱신
            memo[r][c] += dfs(nr, nc, memo)
        }

        // 현재 포인트에서 이동 가능한 모든 경로의 수를 반환
        return memo[r][c]
    }
}

