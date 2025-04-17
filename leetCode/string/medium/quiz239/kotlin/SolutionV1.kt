package string.medium.quiz239.kotlin

class SolutionV1 {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val result = mutableListOf<Int>()
        val deque = ArrayDeque<Int>();

        for (i in nums.indices) {
            while (deque.isNotEmpty() && deque.first() < i - k + 1) {
                deque.removeFirst()
            }

            while (deque.isNotEmpty() && nums[deque.last()] < nums[i]) {
                deque.removeLast()
            }

            deque.addLast(i)

            if (i >= k + 1) {
                result.add(nums[deque.first()])
            }
        }

        return result.toIntArray()
    }
}
