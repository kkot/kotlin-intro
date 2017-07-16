package a09_inline;

public class SpringJava {
    public static void main(String[] args) {
        ContextMap.INSTANCE.registerBean(SimpleService.class, () -> new SimpleService());
    }
}
