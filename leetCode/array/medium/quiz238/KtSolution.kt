package array.medium.quiz238

fun main() {
    val answer = productExceptSelf(intArrayOf(1, 2, 3, 4))
    answer.forEach {
        println(it)
    }
}

fun productExceptSelf(nums: IntArray): IntArray {
    val result = IntArray(nums.size) { 1 }

    // 왼쪽 곱
    var prefixProduct = 1
    for (i in nums.indices) {
        result[i] = prefixProduct
        prefixProduct *= nums[i]
    }

    // 오른쪽 곱
    var suffixProduct = 1
    for (i in nums.indices.reversed()) {
        result[i] *= suffixProduct
        suffixProduct *= nums[i]
    }

    return result
}
