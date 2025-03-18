package bit.easy.quiz338

fun main() {
    val solution = KtSolutionV2()
    val answer = solution.countBits(5)
    println(answer.contentToString())
}

class KtSolutionV2 {
    fun countBits(n: Int): IntArray {
        return IntArray(n + 1).apply {
            for (i in 0..n) {
                this[i] = this[i / 2] + (i and 1)
            }
        }
    }
}
