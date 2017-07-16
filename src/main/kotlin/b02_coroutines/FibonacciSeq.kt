package b02_coroutines

import kotlin.coroutines.experimental.buildSequence

val fibonacciSeq = buildSequence {
    var a = 0
    var b = 1

    println("Start")
    yield(1)

    while (true) {
        yield(a + b)
        println("Step")

        val tmp = a + b
        a = b
        b = tmp
    }
}

fun main(args: Array<String>) {
    fibonacciSeq.take(3).forEach { println("result $it ") }
}
