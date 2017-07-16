package b02_coroutines

import kotlinx.coroutines.experimental.*
import kotlin.system.measureTimeMillis

fun message(message : String) {
    println("$message, Thread ${Thread.currentThread().name}")
}

suspend fun doSomethingUseful() : Int {
    println()
    val waitTime = getWaitTime()
    return computeValue(waitTime)
}

suspend fun getWaitTime(): Int {
    message("getWaitTime")
    delay(5000L) // waiting for some response
    message("getWaitTime finished")
    return (Math.random() * 3000 + 3000).toInt()
}

suspend fun computeValue(waitTime : Int) : Int {
    message("computeValue")
    delay(waitTime.toLong()) // waiting for response
    message("computeValue finished")
    return 42
}

fun main(args: Array<String>) = runBlocking<Unit> {
    val time = measureTimeMillis {
        val one = async(CommonPool) { doSomethingUseful() }
        println("The answer is ${one.await()}")
    }
    println("Completed in $time ms")
}