package info.ilkinabdullayev.basic.lesson7;

public class Tesla implements Car, Vehicle {

    @Override
    public void drive() {
        System.out.println("Tesla started");
    }

    @Override
    public void stop() {
        Car.super.stop();
    }
}
