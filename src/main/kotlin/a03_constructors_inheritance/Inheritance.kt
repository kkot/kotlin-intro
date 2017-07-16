package a03_constructors_inheritance

class Address(// primary constructor
        val street: String, // automatically create field with var or val
        num: Int,
        private val city: String) { // private field

    val homeNum = num

    override fun toString(): String {
        return """
                >Address:
                >street $street $homeNum
                >city $city
                """.trimMargin(">")
    }
}

open class Customer(firstName: String, lastName: String) {
    open val name = firstName + " " + lastName

    // init block (optional) - when we want to do something in primary constructor
    init {
        println("Primary constructor: creating $firstName $lastName")
    }

    open fun isInterested(): String {
        return "maybe"
    }
}

class SpanishCustomer(
        firstName: String,
        lastName: String,
        private val isMan: Boolean?,
        val age: Int = 0)
    : Customer(firstName, lastName) {

    constructor(firstName: String, lastName: String) : this(firstName, lastName, null /*, age has default */) {
        println("Secondary constructor")
    }

    override val name: String // overriding property
        get() = when (isMan) {
            true -> "Señor "
            false -> "Señorita "
            null -> ""
        } + super.name

    override fun isInterested(): String = "yes" // overriding method
}

fun main(args: Array<String>) {
    val message = Address("Gran Via", 4, "Madrid")
    println(message)
    println(message.street)
    //println(message.city) // city is private - will not compile

    val c = Customer("Jan", "Nowak")

    val spanish1 = SpanishCustomer("Santiago", "Lopez", true, 12) // primary
    val spanish2 = SpanishCustomer("Mateo", "Gonzales", true) // primary without parameter with default

    println("--")
    println("Creating Spanish customer")
    val spanish3 = SpanishCustomer("Diego", "Perez")
    println("--")

    println("name ${spanish3.name}, age ${spanish3.age}")
}

