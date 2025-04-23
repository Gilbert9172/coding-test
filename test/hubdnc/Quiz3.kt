package hubdnc

import kotlin.math.sqrt

fun main() {
    Quiz3().solution(10).apply {
        println(this)
    }
}

class Quiz3 {
    fun solution(a: Int): String {
        var sumOfPrimes = 0
        if (a < 4) return printAnswer(a, sumOfPrimes)

        for (num in 2..a) {
            if (num.isPrime()) {
                sumOfPrimes += num
            }
        }
        return printAnswer(a, sumOfPrimes)
    }

    private fun Int.isPrime(): Boolean {
        if (this < 2) return false

        val rightBoundary = sqrt(this.toDouble()).toInt()
        for (i in 2..rightBoundary) {
            if (this % i == 0) return false
        }
        return true
    }

    private fun printAnswer(input: Int, answer: Int) = "a : $input -> $answer"
}
