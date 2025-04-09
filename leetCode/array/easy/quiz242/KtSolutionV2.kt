package array.easy.quiz242

fun main() {
    val s = "aacc"
    val t = "ccac"
    KtSolutionV2().isAnagram(s, t).apply { println(this) }
}

class KtSolutionV2 {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false

        val charArrS = s.toCharArray().apply { this.sort() }
        val charArrT = t.toCharArray().apply { this.sort() }

        for (i in s.indices) {
            if (charArrS[i] != charArrT[i]) return false
        }
        return true
    }
}
