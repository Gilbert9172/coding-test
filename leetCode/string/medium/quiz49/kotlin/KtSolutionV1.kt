package string.medium.quiz49.kotlin

/**
 * [49. Group Anagrams](https://leetcode.com/problems/group-anagrams/)
 */
fun main() {
    val answer = KtSolutionV1().groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat"))
    println(answer.toString())
}

class KtSolutionV1 {

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = HashMap<String, MutableList<String>>()

        strs.forEachIndexed { idx, str ->
            val key = str.toCharArray()
                .sorted()
                .joinToString("")
            map.computeIfAbsent(key) { mutableListOf() }.add(strs[idx])
        }

        return map.values.toList()
    }
}
