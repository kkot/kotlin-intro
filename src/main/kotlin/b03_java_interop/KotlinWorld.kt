@file:JvmName("DemoKotlin")

package b03_java_interop

fun helloWorld() {
    println("Hello world")
}

private // private class in Kotlin is package private in java
object Greeter {
    @JvmField
    val welcomeWord = "Hello"

    val byeWord = "Bye"

    fun hello(name: String) {
        println("Hello $name")
    }

    @JvmName("seeYou")
    fun bye() {

    }

    @JvmStatic
    fun helloStatic() {
        println("Hello static")
    }
}

fun main(args: Array<String>) {
    val javaWorld = JavaWorld()
    javaWorld.meaning = "42"
    println(javaWorld.meaning)

    val list = javaWorld.list
    // list[0].trim(); // runtime exception

    // both assignments below are ok (but second can cause runtime exception)
    val nullableList: MutableList<String?> = javaWorld.list
    val notNullableList: MutableList<String> = javaWorld.list

    notNullableList.size
}

fun canThrowIoException(list: List<*>, to: Appendable) {
    for (item in list) {
        to.append(item.toString()) // Java would require us to catch IOException here
    }
}
