package bit.easy.quiz268

fun main() {
    val array = intArrayOf(0, 1)
    val solution = KtSolutionV3()
    println(solution.missingNumber(array))
}

class KtSolutionV3 {
    fun missingNumber(nums: IntArray): Int {
        var idxSum = nums.size
        var valSum = 0

        for ((index, value) in nums.withIndex()) {
            idxSum += index
            valSum += value
        }

        return idxSum - valSum
    }
}
