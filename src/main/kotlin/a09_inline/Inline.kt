package a09_inline

import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

object Locker {
    inline fun <T> lockInline(lock: Lock, body: () -> T) {
        lock.lock()
        try {
            body()
        } finally {
            lock.unlock()
        }
    }

    fun <T> lockNormal(lock: Lock, body: () -> T) {
        lock.lock()
        try {
            body()
        } finally {
            lock.unlock()
        }
    }
}

fun execute(): Int {
    val lock = ReentrantLock()

    Locker.lockInline(lock, {
        if (Math.random() < 0.5) {
            return 5
        }
    })

    // in Kotlin, there is a convention that if the last parameter to a function is a function, and you're passing
    // a lambda expression as the corresponding argument, you can specify it outside of parentheses
    Locker.lockInline(lock) {
        if (Math.random() < 0.5) {
            return 5
        }
    }

    listOf("a")
            .filter { it.startsWith("a") }
            .forEach {
        println(it)
    }

    return 0
}

fun execute2(): Int {
    val lock = ReentrantLock()

    var result: Int
    Locker.lockNormal(lock) label@ {
        if (Math.random() < 0.5) {
            result = 5 // can access its closure, i.e. the variables declared in the outer scope
        }
        return@label // without @label it there is compilation error
    }

    Locker.lockNormal(lock, fun(): Int { // no lambda but function
        if (Math.random() < 0.5) {
            result = 5 // can access its closure, i.e. the variables declared in the outer scope
        }
        return 1
    });

    return 0
}

fun test() {
    Locker.lockInline(ReentrantLock(), ::execute2) // method reference
}

fun join(first: String, second: String, combiner: (String, String) -> String) { // function type
    combiner(first, second)
}

fun test2() {
    println(join("a", "b", { a, b -> a + b })) // lambda expression
}
