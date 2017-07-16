package b04_builders

class HTML5 {
    fun head() {
        println("Head")
    }
    fun body() {
        println("Body")
    }
}

fun html5(callOnHtml5: HTML5.() -> Unit): HTML5 {
    val html = HTML5()  // create the receiver a05_object_static_methods
    html.callOnHtml5()        // pass the receiver a05_object_static_methods to the lambda
    return html
}

// must be called on HTML5 a05_object_static_methods and this is bound
val onHtml5 = fun HTML5.() {
    this.body()
}

fun main(args: Array<String>) {
    html5 {
        /* this.*/ body()
        /* this.*/ head()
    }

    html5(onHtml5)
}

