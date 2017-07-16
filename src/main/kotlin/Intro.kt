import java.io.Serializable
import java.time.Duration

/**
 * TODO:
 *
 * @author Krzysztof Kot (krzysztof.kot.pl@gmail.com)
 */

class Person(
        val firstName: String,
        val lastName: String,
        val age: Int) {

    init {
        println("Primary constructor")
    }

    constructor(firstName: String, lastName: String) : this(firstName, lastName, 0) {
        println("Secondary constructor")
    }
}

object LanguageUtil : Serializable {
    fun getWelcomePhrase() : String {
        return "Hi"
    }
}

class Greeter(val util: LanguageUtil) {
    fun greet(name: String) {
        // println(LanguageUtil.getWelcomePhrase() + "$name")
        println(util.getWelcomePhrase() + "$name")
    }
}

fun Int.seconds() : Duration {
    return Duration.ofSeconds(this.toLong())
}

fun Greeter.greet() {
    this.greet("unknown")
}

fun nothing() {

}

fun main(args: Array<String>) {

    nothing().apply { println() }

    15.seconds()

    val person1 = Person("Kamil", "K", 18)
    val person2 = Person("Kamil", "K", 18)
    val person3 = Person("Kamil", "K")

    val list = ArrayList<Any>();



    Greeter(LanguageUtil).greet()
    //GreeterUtil.greet(greeter)



    println("equal ${person1 == person2}, same object ${person1 === person2}")
}
