package info.ilkinabdullayev.serializable.basic;

import java.io.*;

public class BasicSerializerApp {

    private static final String FILE_NAME = "person.pen";

    public static void main(String[] args) {
        serialize();
        deserialize();
    }


    public static void serialize() {
        try(OutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

            Person me = new Person(1, "Ilkin", 27);
            objectOutputStream.writeObject(me);

            System.out.println("Object has been serialized successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void deserialize() {
        try(InputStream inputStream = new FileInputStream(FILE_NAME);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {

            Person who = (Person) objectInputStream.readObject();

            System.out.println("Object has been deserialized successfully: " + who);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
