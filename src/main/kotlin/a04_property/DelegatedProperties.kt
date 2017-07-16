package a04_property

import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class Delegate : ReadWriteProperty<Any?, String> {
    override operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    override operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name} in $thisRef.'")
    }
}

class Test {
    val myDelegatedValue by Delegate()
}

fun main1(args: Array<String>) {
    println(Test().myDelegatedValue)
}

// lazy

val lazyValue: String by lazy {
    println("computed!")
    "Hello"
}

fun main2(args: Array<String>) {
    println(lazyValue)
    println(lazyValue)
}

// observable

class User {
    var name: String by Delegates.observable("<no name>") {
        prop, old, new ->
        println("$prop changed from $old to $new")
    }
}

fun main3(args: Array<String>) {
    val user = User()
    user.name = "first"
    user.name = "second"
}

// storing in map

class Customer(val map: Map<String, Any?>) {
    val name: String by map
    val age: Int     by map
}

val user = Customer(mapOf(
        "name" to "John Doe",
        "age" to 25
))

fun main(args: Array<String>) {
    println(user.name) // Prints "John Doe"
    println(user.age)  // Prints 25
}



