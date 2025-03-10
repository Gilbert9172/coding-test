package kotlinsource.chap4

fun main() {
    val nested = Outer.Nested()
    nested.printNestedText()


    val outer = Outer()
    outer.Inner().printOuterText()
    outer.Inner().printInnerText()
}

class Outer {

    val text = "Outer text"

    class Nested {

        fun printNestedText() {
            println("Nested text")
        }
    }

    inner class Inner {

        fun printOuterText() {
            println(this@Outer.text)
        }

        fun printInnerText() {
            println("Inner text")
        }
    }
}

interface UserI {
    val email: String
    val nickname: String
        get() = email.substringBefore('@') // 프로퍼티에 뒷받침하는 필드가 없다. 대신 매번 결과를 계산해 돌려준다.
}
