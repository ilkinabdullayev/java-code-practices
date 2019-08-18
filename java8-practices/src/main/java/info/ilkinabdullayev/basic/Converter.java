package info.ilkinabdullayev.basic;

@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);
}

class Person {
    private int id;

    Person(int id) {
       this.id = id;
    }

    public int getId() {
        return id;
    }
}

class ConverterMain {
    public static void main(String[] args) {
        Converter<String, Integer> converter1 = s -> s.length();
        Integer convertedInteger = converter1.convert("234");

        Converter<Person, Integer> converter2 = s -> s.getId();

        convertedInteger = converter2.convert(new Person(234));
    }
}
