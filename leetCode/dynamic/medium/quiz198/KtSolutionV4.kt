package dynamic.medium.quiz198

fun main() {
    val solution = KtSolutionV4()
    val nums = intArrayOf(2, 7, 9, 3, 1)
    val answer = solution.rob(nums)
    println(answer)
}

class KtSolutionV4 {

    fun rob(nums: IntArray): Int {
        val memo = IntArray(nums.size) { -1 } // -1로 초기화된 메모이제이션 배열
        memo[0] = nums[0] // 첫 번째 집은 무조건 털 수 있다

        // 마지막 집을 털거나, 마지막에서 두 번째 집을 터는 것 중 큰 값을 반환
        return maxOf(recursive(nums.size - 1, memo, nums), recursive(nums.size - 2, memo, nums))
    }

    private fun recursive(n: Int, memo: IntArray, nums: IntArray): Int {
        if (n < 0) return 0 // 인덱스가 범위 밖이면 0을 반환
        if (memo[n] != -1) return memo[n] // 이미 계산된 값이면 바로 반환

        // n번째 집을 털 경우: recursive(n - 2) + nums[n]
        // n번째 집을 안 털 경우: recursive(n - 1)
        val maxPrev = maxOf(recursive(n - 1, memo, nums), recursive(n - 2, memo, nums) + nums[n])
        memo[n] = maxPrev // 계산 결과 저장
        return maxPrev
    }
}
