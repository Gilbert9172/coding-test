package string.medium.quiz49

/**
 * [49. Group Anagrams](https://leetcode.com/problems/group-anagrams/)
 */
fun main() {
    val answer = KtSolutionV3().groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat"))
    println(answer.toString())
}

class KtSolutionV3 {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val indices = HashMap<String, Int>()
        val result = ArrayList<ArrayList<String>>()

        var size = 0

        for (s in strs) {
            val hash = s.freqHashCode()
            var index = indices[hash]

            var bucket: ArrayList<String>
            if (index == null) {
                index = size++
                indices[hash] = index
                bucket = ArrayList()
                result += bucket
            } else {
                bucket = result[index]
            }
            bucket += s
        }

        return result
    }

    private fun String.freqHashCode(): String {
        val freq = CharArray(26)
        for (c in this) freq[c - 'a']++
        return String(freq)
    }
}
