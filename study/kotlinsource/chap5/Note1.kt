package kotlinsource.chap5

data class Chap5Person(
    val name: String,
    val age: Int
) {
    fun greet() = "Hello, my name is $name"
}

fun <T> Collection<T>.joinToStringV2(
    separator: String = ", ",
    prefix: String = "(",
    postfix: String = ")",
    transform: (T) -> String
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(transform(element))
    }
    result.append(postfix)
    return result.toString()
}

fun callFunction(f: () -> String) {
    println(f())
}

fun main() {
    val people = listOf(
        Chap5Person("Gilbert", 31), Chap5Person("Kevin", 26)
    )

    // val oldest = people.maxBy { it.age }
    // val oldest = people.maxBy(Chap5Person::age)
    // println(oldest)

    val answer = people.joinToStringV2(separator = "; ") { it.name }
    println(answer)


    val tom = Chap5Person("Tom", 31)
    val kFunction1 = Chap5Person::greet
    println(kFunction1(tom))

    val boundGreetRef = tom::greet
    val boundGreetLambda = { tom.greet() }
    println(boundGreetRef())
    println(boundGreetLambda())

    callFunction(boundGreetRef)
}

