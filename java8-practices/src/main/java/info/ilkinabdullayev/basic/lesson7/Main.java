package info.ilkinabdullayev.basic.lesson7;

public class Main {

    public static void main(String[] args) {
        Car car = new Tesla();
        car.drive();
        car.stop();


        Car car2 = () -> System.out.println("Vnnnnnnnnnnn");
        car2.drive();
        car2.stop();
    }
}
