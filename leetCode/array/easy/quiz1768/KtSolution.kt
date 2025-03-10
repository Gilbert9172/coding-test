package array.easy.quiz1768


/**
 *  [ Constrains ]
 *  1 <= word1.length, word2.length <= 100
 *  word1 and word2 consist of lowercase English letters.
 */

fun main() {
    val answer = mergeAlternately("abc", "zz")
    println(answer)
}

fun mergeAlternately(word1: String, word2: String): String {
    var aPointer = 0
    var bPointer = 0
    val word1LastIdx = word1.lastIndex
    val word2LastIdx = word2.lastIndex

    return buildString {
        // End Condition : both pointer at last idx
        while (aPointer <= word1LastIdx || bPointer <= word2LastIdx) {
            if (aPointer <= word1LastIdx) {
                append(word1[aPointer])
                aPointer++
            }

            if (bPointer <= word2LastIdx) {
                append(word2[bPointer])
                bPointer++
            }
        }
    }
}
