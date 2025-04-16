package string.medium.quiz567.kotlin

class SolutionV1 {
    fun checkInclusion(s1: String, s2: String): Boolean {
        val len1 = s1.length
        val len2 = s2.length
        if (len1 > len2) return false

        val s1Count = IntArray(26)
        val s2Count = IntArray(26)

        for (i in 0 until len1) {
            s1Count[s1[i] - 'a']++
            s2Count[s2[i] - 'a']++
        }

        if (matched(s1Count, s2Count)) return true

        for (i in len1..s2.lastIndex) {
            s2Count[s2[i] - 'a']++
            s2Count[s2[i - len1] - 'a']--
            if (matched(s1Count, s2Count)) return true
        }

        return false;
    }

    private fun matched(a: IntArray, b: IntArray): Boolean {
        for (i in 0..25) {
            if (a[i] != b[i]) return false
        }
        return true
    }
}

