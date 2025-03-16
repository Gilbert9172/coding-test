package array.easy.quiz1

fun main() {
    val solution = KtSolution()
    val twoSum = solution.twoSum(intArrayOf(2, 7, 11, 15), 9)
    println(twoSum.toString())
}

class KtSolution {

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map: MutableMap<Int, Int> = hashMapOf()
        for (i in 0..nums.lastIndex) {
            val minusResult = target - nums[i]
            if (map.containsKey(minusResult)) {
                return intArrayOf(map[minusResult]!!, i)
            }
            map[nums[i]] = i
        }
        return intArrayOf()
    }
}
