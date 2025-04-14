package string.medium.quiz3

class KtSolutionV1 {
    fun lengthOfLongestSubstring(s: String): Int {
        val visited = mutableMapOf<Char, Int>()
        var left = 0
        var right = 0
        var maxLen = 0

        for (c in s.toCharArray()) {
            if (visited.containsKey(c) && left <= visited[c]!!) {
                left = visited[c]!! + 1
            } else {
                maxLen = maxOf(maxLen, right - left + 1)
            }
            visited[c] = right
            right++
        }

        return maxLen
    }
}
