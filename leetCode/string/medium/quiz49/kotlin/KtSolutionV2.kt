package string.medium.quiz49.kotlin

/**
 * [49. Group Anagrams](https://leetcode.com/problems/group-anagrams/)
 */
fun main() {
    val answer = KtSolutionV2().groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat"))
    println(answer.toString())
}

class KtSolutionV2 {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = mutableMapOf<String, MutableList<String>>()

        strs.forEach {
            val key = it.freqHashCode()
            map.computeIfAbsent(key) { mutableListOf() }.add(it)
        }

        return map.values.toList()
    }

    private fun String.freqHashCode(): String {
        val freq = CharArray(26) // 알파벳 빈도 수 저장
        for (c in this) freq[c - 'a']++
        // freq 배열을 문자열로 변환하여 해시 키로 사용
        return freq.joinToString("#") // 구분자를 넣어야 ["11"]과 ["1", "1"]을 구분 가능
    }
}
