package array.medium.quiz347

import java.util.*

fun main() {
    val nums = intArrayOf(1, 2)
    val k = 2
    KtSolutionV1().topKFrequent(nums, k).apply {
        println(this.toList().toString())
    }
}

class KtSolutionV1 {

    data class Frequent(val num: Int, val count: Int)

    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        if (nums.isEmpty()) return intArrayOf()

        val countMap = mutableMapOf<Int, Int>()
        nums.forEach {
            countMap[it] = countMap.getOrDefault(it, 0) + 1
        }

        val pq = PriorityQueue(compareByDescending<Frequent> { it.count })
        val frequentList = countMap.map { (key, value) -> Frequent(key, value) }
        pq.addAll(frequentList)

        val result = mutableListOf<Int>()
        for (i in 1..k) {
            result.add(pq.poll().num)
        }

        return result.toIntArray()
    }
}
