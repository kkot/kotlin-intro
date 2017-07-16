package a09_inline

class SimpleService

object ContextMap {
    private val registered: MutableMap<Class<Any>, Any> = HashMap()

    inline fun <reified T : Any> registerBean(noinline creator: () -> T) {
        registerBean(T::class.java, creator);
    }

    fun <T : Any> registerBean(classJava: Class<T>, creator: () -> T) {
        registered.put(classJava as Class<Any>, creator())
    }
}

fun main(args: Array<String>) {
    ContextMap.registerBean { SimpleService() } // not need to pass type explicitly, compare with SpringJava.java
    ContextMap.registerBean(SimpleService::class.java) { SimpleService() }
}

