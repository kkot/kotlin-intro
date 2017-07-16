package b01_generics.java;

interface JProducer<T> {
    T get(String color);
}

public class JGenerics {

    public void getTenCars(JProducer<? extends Car> producer) {
        for (int i = 0; i < 10; i++) {
            System.out.println("Produced " + producer.get(null));
        }
    }

    public static void main(String[] args) {
        JProducer<Volvo> volvoProducer = color -> new Volvo();

        new JGenerics().getTenCars(volvoProducer);

    }

}
