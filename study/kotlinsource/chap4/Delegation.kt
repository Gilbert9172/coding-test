package kotlinsource.chap4

fun main() {
    val defaultPrinter = DefaultPrinter()
    val byCustomPrinter = ByCustomPrinter(defaultPrinter)
    byCustomPrinter.printMessage()
    byCustomPrinter.customMessage()
}

interface Printer {
    fun printMessage()
}

class DefaultPrinter : Printer {
    override fun printMessage() {
        println("Default Printer")
    }
}

class CustomPrinter(
    private val printer: Printer
) : Printer {
    override fun printMessage() {
        printer.printMessage()
        println("Custom Printer")
    }
}

/**
 * ByCustomPrinter 클래스는 Printer 인터페이스를 직접 구현하지 않아도,
 * DefaultPrinter의 모든 기능을 위임할 수 있다.
 */
class ByCustomPrinter(
    private val printer: Printer
) : Printer by printer {
    fun customMessage() {
        println("Custom Printer")
    }
}
