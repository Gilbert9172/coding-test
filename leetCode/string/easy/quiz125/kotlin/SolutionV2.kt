package string.easy.quiz125.kotlin

fun main() {
    SolutionV2().isPalindrome("A man, a plan, a canal: Panama").apply {
        println(this)
    }
}

class SolutionV2 {
    fun isPalindrome(s: String): Boolean {
        var left = 0
        var right = s.lastIndex

        while (left < right) {
            while (left < right && !isAlphanumericOrDigit(s[left].toLowerCase())) {
                left++
            }

            while (left < right && !isAlphanumericOrDigit(s[right].toLowerCase())) {
                right++
            }

            if (s[left].toLowerCase() != s[right].toLowerCase()) {
                return false
            }

            left++
            right--
        }

        return true
    }

    private fun isAlphanumericOrDigit(c: Char): Boolean {
        return (c in 'a'..'z') || (c in '0'..'9')
    }

    private fun Char.toLowerCase(): Char {
        return if (this in 'A'..'Z') this + 32 else this
    }
}
