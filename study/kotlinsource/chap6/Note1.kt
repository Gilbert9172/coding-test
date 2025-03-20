package kotlinsource.chap6

fun main() {
    val note = Note1()
    note.testMethod2()
}

class Note1 {
    fun testMethod1(input: String?) {
        if (input.isNullOrBlank()) {
            println("false")
        }
    }

    fun <T : Any> printHashCode(t: T) {
        println(t.hashCode())
    }

    fun testMethod2() {
        val num = 333333333333333333
        val toInt = num.toInt()
        println(toInt)
    }
}
