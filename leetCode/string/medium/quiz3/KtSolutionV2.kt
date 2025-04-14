package string.medium.quiz3

fun main() {
    val answer = KtSolutionV2().lengthOfLongestSubstring("pwwkew")
    println(answer)
}

class KtSolutionV2 {
    fun lengthOfLongestSubstring(s: String): Int {
        val charSet = HashSet<Char>()
        var l = 0
        var res = 0

        for (r in s.indices) {
            while (s[r] in charSet) {
                charSet.remove(s[l])
                l++
            }
            charSet.add(s[r])
            res = maxOf(res, r - l + 1)
        }
        return res
    }
}
