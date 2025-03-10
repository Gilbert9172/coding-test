package array.easy.quiz217

fun main() {
    val intArray = intArrayOf(1, 2, 3, 4, 1)
    val answer = containsDuplicate(intArray)
    println(answer)
}

fun containsDuplicate(nums: IntArray): Boolean {

    val hashSet = HashSet<Int>()
    for (i in nums) {
        if (!hashSet.add(i)) {
            return true
        }
    }
    return false
}
