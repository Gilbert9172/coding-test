package bit.easy.quiz268

fun main() {
    val array = intArrayOf(0, 1)
    val solution = KtSolutionV2()
    println(solution.missingNumber(array))
}

class KtSolutionV2 {
    fun missingNumber(nums: IntArray): Int {
        var idxSum = 0
        var valSum = 0
        for (i in 0..nums.lastIndex) {
            idxSum += i + 1
            valSum += nums[i]
        }

        return idxSum - valSum
    }
}
