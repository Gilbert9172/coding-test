package string.hard.quiz76

fun main() {
    val s = "ADOBECODEBANC"
    val t = "ABC"
    KtSolutionV1().minWindow(s, t).apply {
        println(this)
    }
}

class KtSolutionV1 {
    fun minWindow(s: String, t: String): String {
        if (t.length > s.length) return ""

        val targetMap = mutableMapOf<Char, Int>()
        val windowMap = mutableMapOf<Char, Int>()

        for (c in t) {
            targetMap[c] = targetMap.getOrDefault(c, 0) + 1
        }

        val required = targetMap.size
        var left = 0
        var right = 0
        var formed = 0
        var minLen = Int.MAX_VALUE
        var minStart = 0

        while (right < s.length) {
            val c = s[right]
            if (c in targetMap) {
                windowMap[c] = windowMap.getOrDefault(c, 0) + 1
                if (windowMap[c] == targetMap[c]) formed++
            }

            while (formed == required) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1
                    minStart = left
                }

                val leftChar = s[left]
                if (leftChar in targetMap) {
                    windowMap[leftChar] = windowMap[leftChar]!! - 1
                    if (windowMap[leftChar]!! < targetMap[leftChar]!!) {
                        formed--
                    }
                }
                left++
            }
            right++
        }

        return if (minLen == Int.MAX_VALUE) "" else s.substring(minStart, minStart + minLen)
    }
}
