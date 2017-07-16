import kotlinx.coroutines.experimental.*
import kotlin.system.measureTimeMillis

suspend fun multipleCoroutines() {
    val took = measureTimeMillis {
        val context = newFixedThreadPoolContext(4,"My thread") // a thread can execute multiple routines
        val jobs = (1..20_000).map {
            launch(context) { // launch create coroutine
                httpCall(it)
            }
        }
        jobs.forEach { it.join() } // wait for all jobs to complete
        println()
    }
    println("Took $took milliseconds")
}

suspend fun httpCall(num : Int) {
    println("($num) I'm working in thread ${Thread.currentThread().name}")
    delay(1000L)
    print(".")
}

fun main(args: Array<String>) = runBlocking<Unit> {
    multipleCoroutines()
}
