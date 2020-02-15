package info.ilkinabdullayev.basic.lesson10;

import info.ilkinabdullayev.Person;

public interface PersonFactory<P extends Person> {
    P create(int id, String name);
}
