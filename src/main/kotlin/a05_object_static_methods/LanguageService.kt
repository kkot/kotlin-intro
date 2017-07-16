package a05_object_static_methods

object LanguageService {
    fun getWelcomePhrase(): String = "Hello"
}

interface GreeterFactory {
    fun create(): Greeter
}

open class Greeter(val langUtil: LanguageService) {
    fun greetPolyglot(name: String): String {
        return LanguageService.getWelcomePhrase() + " $name" // similar to java static method
    }

    fun greetPolyglotTestFriendly(name: String): String {
        return langUtil.getWelcomePhrase() + " $name" // because object is singleton we can also pass instance to allow unit testing
    }

    // companion object is used when we want to have static methods on normal class
    companion object Factory : GreeterFactory { // object can extend a class and implement interfaces
        override fun create(): Greeter {
            return Greeter(LanguageService)
        }
    }
}

fun main(args: Array<String>) {
    val greeter = Greeter(LanguageService)
    println(greeter.greetPolyglot("Carol"))
    println(greeter.greetPolyglotTestFriendly("John"))

    val greeter2 = Greeter.create() // looks like java static method
}
