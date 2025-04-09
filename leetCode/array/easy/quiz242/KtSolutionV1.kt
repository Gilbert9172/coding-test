package array.easy.quiz242

fun main() {
    val s = "aacc"
    val t = "ccac"
    KtSolutionV1().isAnagram(s, t).apply { println(this) }
}

class KtSolutionV1 {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        val charMap = mutableMapOf<Char, Int>()
        for (c in s.toCharArray()) {
            charMap.putIfAbsent(c, 0)
            charMap[c] = charMap[c]!! + 1
        }

        for (c in t.toCharArray()) {
            if (charMap.containsKey(c)) {
                charMap[c] = charMap[c]!! - 1
            }
        }

        for (count in charMap.values) {
            if (count != 0) return false
        }
        return true
    }
}
