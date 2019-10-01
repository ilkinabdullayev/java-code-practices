package info.ilkinabdullayev.advanced.lesson1;


import info.ilkinabdullayev.advanced.lesson1.annotations.Data;
import info.ilkinabdullayev.advanced.lesson1.annotations.Hello;
import info.ilkinabdullayev.advanced.lesson1.annotations.ViewName;

@Data
@Hello("Ilkin")
@Hello("David")
public class Student {

    private int id;

    @ViewName("NAME")
    private String name;

    @ViewName("MAX_AGE")
    private int age;



}
