package hubdnc

fun main() {
    val arr = intArrayOf(1, 2, 3)
    Quiz8().solution(arr).apply {
        println(this)
    }
}

class Quiz8 {
    private var permutationCount = 0

    fun solution(arr: IntArray): Int {
        if (arr.isEmpty()) return 0

        val visited = BooleanArray(arr.size)
        countPermutations(arr, visited, mutableListOf())

        return permutationCount
    }

    private fun countPermutations(arr: IntArray, visited: BooleanArray, bucket: MutableList<Int>) {
        if (bucket.size == arr.size) {
            permutationCount++
            return;
        }

        for ((idx, value) in arr.withIndex()) {
            if (visited[idx]) continue
            visited[idx] = true
            bucket.add(value)
            countPermutations(arr, visited, bucket)
            visited[idx] = false
            bucket.removeLast()
        }
    }
}
