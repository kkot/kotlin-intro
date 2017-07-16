package b01_generics

import b01_generics.java.JGenerics

open class Car

open class Volvo : Car()

interface Producer<out T> {
    fun get(): T
}

interface Cleaner<in T> {
    fun clean(o: T)
}

fun buyTenCars(carManufacturer: Producer<Car>) {
    for (i in 0..10) {
        println(carManufacturer.get())
    }

}

fun cleanMyVolvo(volvoCleaner : Cleaner<Volvo>) {

}

fun main(args: Array<String>) {
    val volvoProducer: Producer<Volvo> =
            object : Producer<Volvo> {
                override fun get(): Volvo {
                    return Volvo()
                }
            }

    buyTenCars(volvoProducer)

    var cleanerOnlyVolvo: Cleaner<Volvo> = object : Cleaner<Volvo> {
        override fun clean(o: Volvo) {
        }

    }
    var cleanerStandard: Cleaner<Car> =
            object : Cleaner<Car> {
        override fun clean(o: Car) {
            Thread({ println("x")})
        }
    }

    cleanMyVolvo(cleanerStandard)
    cleanMyVolvo(cleanerOnlyVolvo)

    JGenerics().getTenCars { _ -> b01_generics.java.Car() }

}

