package array.easy.quiz242

fun main() {
    val s = "aacc"
    val t = "ccac"
    KtSolutionV3().isAnagram(s, t).apply { println(this) }
}

class KtSolutionV3 {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false

        val charArrS = s.toCharArray()
        val charArrT = t.toCharArray()
        val alphabets = IntArray(26)

        for (i in s.indices) {
            alphabets[charArrS[i] - 'a']++
            alphabets[charArrT[i] - 'a']--
        }

        for (alphabet in alphabets) {
            if (alphabet != 0) return false
        }
        return true
    }
}
