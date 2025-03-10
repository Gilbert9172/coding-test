package kotlinsource.chap5

fun makeCounter(): () -> Int {
    var count = 0  // 클로저로 캡처되는 변수
    return {
        count++
        count
    }
}

fun main() {
    val counter1 = makeCounter()
    println(counter1())  // 1
    println(counter1())  // 2

    val counter2 = makeCounter()  // 새로운 상태 유지
    println(counter2())  // 1
}
