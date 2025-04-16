package string.hard.quiz76

fun main() {
    val s = "ADOBECODEBANC"
    val t = "ABC"
    KtSolutionV2().minWindow(s, t).apply {
        println(this)
    }
}

class KtSolutionV2 {
    fun minWindow(s: String, t: String): String {
        val tMap = IntArray(128)

        for (c in t) {
            tMap[c.code]++
        }

        var startIndex = 0
        var left = 0
        var right = 0
        var len = t.length
        var min = Int.MAX_VALUE

        while (right < s.length) {
            val c1 = s[right]
            tMap[c1.code]--

            if (tMap[c1.code] >= 0) {
                len--
            }

            while (len == 0) {
                val size = right - left + 1
                if (size < min) {
                    min = size
                    startIndex = left
                }
                val c2 = s[left]
                tMap[c2.code]++
                if (tMap[c2.code] > 0) {
                    len++
                }
                left++
            }
            right++
        }

        return if (min == Int.MAX_VALUE) "" else s.substring(startIndex, startIndex + min)
    }
}
