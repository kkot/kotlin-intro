package a04_property

abstract class Example {

    var num: Int? = null
    var all = true // type inferred

    abstract var notIntialized: Int?

    var size
        get() = (Math.random() * 10.toDouble()).toInt()
        private set(value) {}

    var area: Int = 0
        get
        set(value) {
            field = (value / 10) * 10
        }
}

class RealExample(override var notIntialized: Int?) : Example() {

}

fun main(args: Array<String>) {
    println(RealExample(1).size)

    val realExample = RealExample(1)
    realExample.area = 1234
    println(realExample.area)
}

