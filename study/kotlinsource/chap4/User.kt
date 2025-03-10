package kotlinsource.chap4

fun main() {
    val user = User("Alice")
    user.address = "서울시 노원구 노원로22길 34"
}

class User(
    val name: String
) {
    var address: String = "unspecified"
        set(value: String) {
            println(
                """
                Address was changed for $name:
                "$field" -> "$value".""".trimIndent()
            )
            field = value
        }
}
