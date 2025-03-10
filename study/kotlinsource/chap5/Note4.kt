package kotlinsource.chap5

fun main() {
    val alphabetWithV1 = alphabetWithV1()
    val alphabetWithV2 = alphabetWithV2()
    println(alphabetWithV1)
    println(alphabetWithV2)

    val alphabetApplyV1 = alphabetApplyV1()
    println(alphabetApplyV1)

    val alphabetBuildString = alphabetBuildString()
    println(alphabetBuildString)
}

fun alphabetWithV1(): String {
    val stringBuilder = StringBuilder()
    return with(stringBuilder) {
        for (letter in 'A'..'Z') {
            this.append(letter)
        }
        this.toString()
    }
}

fun alphabetWithV2(): String {
    return with(StringBuilder()) {
        for (letter in 'A'..'Z') {
            append(letter)
        }
        toString()
    }
}

fun alphabetApplyV1() = StringBuilder().apply {
    for (letter in 'A'..'Z') {
        this.append(letter)
    }
}.toString()

fun alphabetBuildString() = buildString {
    for (letter in 'A'..'Z') {
        append(letter)
    }
}

