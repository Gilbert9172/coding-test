package bit.easy.quiz191

fun main() {
    val solution = KtSolutionV3()
    val answer = solution.hammingWeight(11)
    println(answer)
}

class KtSolutionV3 {
    fun hammingWeight(n: Int): Int {
        return n.countOneBits()
    }
}
