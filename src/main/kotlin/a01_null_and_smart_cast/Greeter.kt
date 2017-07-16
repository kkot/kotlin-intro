package a01_null_and_smart_cast
import User as UserAlias

class Person(val name: String)

open class Greeter() {

    lateinit var unknownName : String

    open fun greetNameOrNull(name: String? = null): String { // default methods, nullable
        if (name == null) {
            return "Hello stranger";
        }
        return if (name.length > 5) // non null here (flow analysis), if as expression
            "Hello $name" // string interpolation (template)
        else
            "Hi $name"
    }

    fun greetAny(who: Any): String {
        return if (who is String?) {
            greetNameOrNull(who)
        } else if (who is Person) {
            greetNameOrNull(who.name)
        } else
            throw IllegalArgumentException()
    }

    fun greetIfPerson(who: Any): String {
        if (who !is Person) {
            throw IllegalArgumentException()
        }
        return who.name // here who can only be instance of a01_null_and_smart_cast.Person class
    }

    fun greetWhen(obj: Any? = null): String { // default methods, nullable
        return when (obj) { // when expression
            null -> "Hello stranger"
            is String -> "Hello ${obj}"
            is Person -> "Hello ${obj.name}"
            else -> "Hi unknown"
        }
    }

    fun greetUnknown() : String {
        return unknownName
    }
}

fun main(args: Array<String>) {
    val greeter = Greeter() // no new, no semicolon
    // greeter = Greeter() // val means final (but is shorter :)), no reassignment possible

    var greeting = greeter.greetAny(Person("Adam"))
    println(greeting)

    greeting = greeter.greetIfPerson(who = Person(name = "Alex")) // named parameter

    greeter.unknownName = "John Doe" // try commenting this line
    greeter.greetUnknown()

    val user = UserAlias() // import statement can introduce alias
}

