package hubdnc

fun main() {
    Quiz2().solution(intArrayOf(1, 2, 3, 4)).apply {
        println(this)
    }
}

class Quiz2 {
    private val combinations = mutableListOf<List<Int>>()

    fun solution(arr: IntArray): Int {
        findCombinations(0, arr, mutableListOf())

        var sumOfLCM = 0
        combinations.forEach { (num1, num2) -> sumOfLCM += lcm(num1, num2) }

        return sumOfLCM
    }

    private fun findCombinations(idx: Int, arr: IntArray, bucket: MutableList<Int>) {
        if (bucket.size == 2) {
            combinations.add(bucket.toList())
            return
        }

        for (i in idx..arr.lastIndex) {
            bucket.add(arr[i])
            findCombinations(i + 1, arr, bucket)
            bucket.removeLast()
        }
    }

    private fun lcm(num1: Int, num2: Int): Int {
        val maxNum = maxOf(num1, num2)
        val minNum = minOf(num1, num2)
        return (maxNum * minNum) / gcd(maxNum, minNum)
    }

    private fun gcd(num1: Int, num2: Int): Int {
        return if (num2 == 0) num1 else gcd(num2, num1 % num2)
    }
}
