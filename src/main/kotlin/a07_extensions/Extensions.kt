package a07_extensions

import User
import SuperUser

import java.time.Duration

fun Int.secs(): Duration {
    return Duration.ofSeconds(this.toLong());
}

fun String.goNuts(): String {
    return this.map {
        when (it) {
            'o' -> '0'
            'H' -> '5'
            'l' -> '1'
            else -> it
        }
    }.joinToString("")
}

fun User.whoAmI(): String = "User ${this.name}"

fun SuperUser.whoAmI(): String = "SuperUser ${this.name}"

fun main(args: Array<String>) {
    println("Time period " + (5.secs() + 10.secs()))
    println("Hello World".goNuts())

    val user = User("user123")
    val superUser = SuperUser("admin")

    println(user.whoAmI())
    println(superUser.whoAmI())

    val user2: User = superUser
    println(user2.whoAmI()) // in runtime it is SuperUser but extension method are resolved in compile time
}
