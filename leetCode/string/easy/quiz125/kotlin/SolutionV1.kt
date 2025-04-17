package string.easy.quiz125.kotlin

fun main() {
    SolutionV1().isPalindrome("A man, a plan, a canal: Panama").apply {
        println(this)
    }
}

class SolutionV1 {
    fun isPalindrome(s: String): Boolean {
        val cleanedInput = s.doCleaning();
        val n = cleanedInput.length

        for (left in 0 until n / 2) {
            val right = n - 1 - left
            if (cleanedInput[left] != cleanedInput[right]) return false
        }
        return true
    }

    private fun String.doCleaning(): String {
        return with(StringBuilder()) {
            for (c in this@doCleaning) {
                if (Character.isLetterOrDigit(c)) append(c)
            }
            toString().lowercase()
        }
    }
}
