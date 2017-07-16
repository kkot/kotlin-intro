package a07_extensions

open class LanguageService {
    fun getWelcomePhrase() : String {
        return "Hi"
    }
}

object LanguageUtil : LanguageService() {

}

class TestableGreeter(val service: LanguageService) {
    fun greet(name: String) {
        println(service.getWelcomePhrase() + " $name")
        println(LanguageUtil.getWelcomePhrase() + "$name")
    }
}