package info.ilkinabdullayev.basic.lesson7;

public interface Vehicle {
    void drive();

    default void stop() {
        System.out.println("Vehicle Engine is stopping...");
    }
}
