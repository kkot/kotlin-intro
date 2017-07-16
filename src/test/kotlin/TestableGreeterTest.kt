import a07_extensions.LanguageService
import a07_extensions.LanguageUtil
import a07_extensions.TestableGreeter
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

import org.hamcrest.CoreMatchers.`is` as _is

class TestableGreeterTest {
    lateinit var greeter : TestableGreeter

    @Before
    fun setUp() {
        // line below require enabling mocking final because object can't be open
        val languageUtil = Mockito.mock(LanguageUtil.javaClass)
        Mockito.`when`(languageUtil.getWelcomePhrase()).thenReturn("Hej")

        // this is better (if we make our object extends regular class)
        val languageService = Mockito.mock(LanguageService::class.java)
        Mockito.`when`(languageService.getWelcomePhrase()).thenReturn("Hej")

        greeter = TestableGreeter(languageUtil)
        greeter = TestableGreeter(languageService)
    }

    @Test
    fun shouldGreet() {
        greeter.greet("Adam")
    }

}