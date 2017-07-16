package b03_java_interop

interface MyRunnable {
    fun run()
}

fun callRunnable(r: Runnable) {

}

fun callMyRunnable(r: MyRunnable) {

}

fun callKotlinWay(r : () -> Unit) {

}

fun main(args: Array<String>) {
    val javaWorld = JavaWorld()

    // SAM Conversion (nice)
    javaWorld.call { println("This runs in a runnable") }

    // not so nice
    callRunnable(Runnable { println("x") });

    // Also note that this feature works only for Java interop; since Kotlin has proper function types, automatic
    // conversion of functions into implementations of Kotlin interfaces is unnecessary and therefore unsupported
    // callMyRunnable (MyRunnable { println("x")}); // will no compile
    callMyRunnable(object : MyRunnable {
        override fun run() {
            println("anonymous")
        }
    })

    callKotlinWay { println("Kotlin style") }
}
