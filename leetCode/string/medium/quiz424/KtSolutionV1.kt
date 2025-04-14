package string.medium.quiz424

fun main() {
    KtSolutionV1().characterReplacement("AABABBA", 1)
}

class KtSolutionV1 {
    fun characterReplacement(s: String, k: Int): Int {
        val count = IntArray(26)
        var left = 0
        var maxCount = 0
        var maxLength = 0

        for (right in s.indices) {
            val idx = s[right] - 'A'
            count[idx]++
            maxCount = maxOf(maxCount, count[idx])

            while ((right - left + 1) - maxCount > k) {
                count[s[left] - 'A']--
                left++
            }

            maxLength = maxOf(maxLength, right - left + 1)
        }

        return maxLength
    }
}
