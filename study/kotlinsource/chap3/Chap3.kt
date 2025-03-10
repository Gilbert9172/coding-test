package kotlinsource.chap3

fun main() {
    val list = listOf(1, 2, 3)
    val answer = list.joinToStringV1(separator = "; ")
    println(answer)
}

class Chap3(
    val str1: String = "",
    private val str2: String = ""
) {

    fun printMyName() {
        println("gilbert")
    }

}


