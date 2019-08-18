package info.ilkinabdullayev.serializable.complex;

import java.io.*;
import java.util.Arrays;

public class ComplexSerializerApp {

    private static final String FILE_NAME = "customer.pen";

    public static void main(String[] args) {
        serialize();
        deserialize();
    }


    public static void serialize() {
        try(OutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

            Customer customer = new Customer(1, "Alex", 32,
                    Arrays.asList(
                            new Telephone(1, "323-232323-23232"),
                            new Telephone(2, "343-343434-34344")
                    ));

            objectOutputStream.writeObject(customer);

            System.out.println("Object has been serialized successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void deserialize() {
        try(InputStream inputStream = new FileInputStream(FILE_NAME);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {

            Customer customer = (Customer) objectInputStream.readObject();

            System.out.println("Object has been deserialized successfully: " + customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
