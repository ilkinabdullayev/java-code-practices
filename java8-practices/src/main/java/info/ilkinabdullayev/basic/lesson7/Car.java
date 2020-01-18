package info.ilkinabdullayev.basic.lesson7;

public interface Car {

    void drive();

    default void stop() {
        System.out.println("Car Engine is stopping...");
    }
}
