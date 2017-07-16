package b05_closed_by_default

import a01_null_and_smart_cast.Person


// Author Andrey Breslav explains why closed and public by default:
// https://discuss.kotlinlang.org/t/a-bit-about-picking-defaults/1418

// uncomment open below

/* open */ class Open {
    open val something : Any = Object()

    open var user : Person = Person("a")
        private set(value) { field = value } // when class is open an open var can't have a private setter

    fun doSomething() {
        if (something is Person) {
            println(something.name) // when class is open then smart cast is not possible
        }
    }
}

/*
class Evil : Open() {
    override val something: Any
        get() = if (Math.random() < 0.5) Person("b") else Object()
}
*/

// A smart cast is only valid when multiple accesses of the same property
// are guaranteed to return the same value.
//
// https://discuss.kotlinlang.org/t/what-is-the-reason-behind-smart-cast-being-impossible-to-perform-when-referenced-class-is-in-another-module/2201
