package hubdnc

fun main() {
    Quiz7().`O(logn)`(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 11)
}

class Quiz7 {

    // O(n²)
    fun `O(n²)`(n: Int) {
        for (i in 0..n) {
            for (k in 0..n) {
                println("O(n²)")
            }
        }
    }

    // O(n)
    fun `O(n)`(n: Int) {
        for (i in 0..n) {
            println("O(n)")
        }
    }

    // O(nlogn)
    fun `O(nlogn)`(arr: IntArray) {
        arr.sorted()
    }

    // O(logn)
    fun `O(logn)`(arr: IntArray, n: Int) {
        var left = 0
        var right = arr.lastIndex

        while (left <= right) {
            val mid = left + (right - left) / 2
            if (arr[mid] < n) {
                left = mid + 1
            } else if (arr[mid] > n) {
                right = mid - 1
            } else {
                println("O(logn)")
                break
            }
        }
    }

    // O(1)
    fun `O(1)`() {
        println("O(1)")
    }
}
