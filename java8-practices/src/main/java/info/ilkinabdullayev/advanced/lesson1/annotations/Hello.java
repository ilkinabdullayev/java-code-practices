package info.ilkinabdullayev.advanced.lesson1.annotations;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Multiple.class)
public @interface Hello {

    String value();
}
