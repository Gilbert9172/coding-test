package hubdnc

fun main() {
    val arr = arrayOf(intArrayOf(1, 5), intArrayOf(5, 5), intArrayOf(2, 4))
    Quiz1().solution(arr).apply { println(this) }
}

class Quiz1 {
    data class AnswerSheet(val user: String, val score: Int)

    private val users = mapOf(1 to "a", 3 to "b", 5 to "c")
    private val scores = mutableMapOf("a" to 0, "b" to 0, "c" to 0)

    fun solution(arr: Array<IntArray>): String {
        val answerSheets = convertingFrom(arr)

        var highestScore = 0
        for ((user, score) in answerSheets) {
            scores[user] = scores[user]!! + score
            highestScore = maxOf(highestScore, scores[user]!!)
        }

        return scores.filter { it.value == highestScore }
            .map { "${it.key} : ${it.value}" }
            .joinToString(", ")
    }

    private fun convertingFrom(arr: Array<IntArray>): Array<AnswerSheet> {
        return arr.mapNotNull {
            val userId = it[0]
            val score = it[1]
            users[userId]?.let { name -> AnswerSheet(name, score) }
        }.toTypedArray()
    }
}
