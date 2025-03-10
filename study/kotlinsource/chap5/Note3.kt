package kotlinsource.chap5

fun main() {
    simpleCollection()
    studySequence()
}

// Java Stream API 유사하다.
fun studySequence() {
    val upStream = listOf(1, 2, 3, 4)
    upStream.asSequence()
        .map {
            println("map 연산 = $it")
            it * it
        }
        .filter {
            println("filter 연산 = $it")
            it > 0
        }
        .toList() // 최종 연산을 하지 않으면 중간 연산이 출력되지 않음.
}

fun simpleCollection() {
    listOf(1, 2, 3, 4)
        .map {
            println("map 연산 = $it")
            it * it
        }
        .filter {
            println("filter 연산 = $it")
            it > 0
        }
        .toList()
}
