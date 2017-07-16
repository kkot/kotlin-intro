package b03_java_interop;

import java.util.ArrayList;
import java.util.List;

public class JavaWorld {

    private String meaning;

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public List<String> getList() {
        List<String> l = new ArrayList<>();
        l.add(null);
        return l;
    }

    public void call(Runnable r) {

    }

    public static void main(String[] args) {
        DemoKotlin.helloWorld();
        Greeter.INSTANCE.hello("Kotlin");
        //Greeter.INSTANCE.hello(null); // throws IllegalArgumentException
        System.out.println(Greeter.welcomeWord);
        Greeter.INSTANCE.getByeWord();
        Greeter.helloStatic();
        Greeter.INSTANCE.seeYou();
    }
}
