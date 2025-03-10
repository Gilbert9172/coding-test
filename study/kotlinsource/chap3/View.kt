package kotlinsource.chap3

fun main() {
    val view = View()
}

open class View {
    open fun click() = println("View Clicked")
}

class Button : View() {
    override fun click() = println("Button Clicked")
}

abstract class Scroll {
    abstract fun down()
}

class Gilbert : Scroll() {
    override fun down() {
        println("down")
    }
}
