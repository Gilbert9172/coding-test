package kotlinsource.chap3

fun <T> Collection<T>.joinToStringV1(
    separator: String = ", ",
    prefix: String = "(",
    postfix: String = ")"
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun Chap3.printYourName() {
    println(str1)
    println("kevin")
}
