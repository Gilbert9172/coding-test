package bit.easy.quiz191

fun main() {
    val solution = KtSolutionV2()
    val answer = solution.hammingWeight(11)
    println(answer)
}

class KtSolutionV2 {
    fun hammingWeight(n: Int): Int {
        var count = 0
        var number = n
        while (number != 0) {
            count += number and 1
            number = number shr 1
        }
        return count
    }
}
