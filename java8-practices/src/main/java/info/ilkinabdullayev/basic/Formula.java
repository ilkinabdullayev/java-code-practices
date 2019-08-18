package info.ilkinabdullayev.basic;

public interface Formula {
    double calculate(int a);

    //extension methods
    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
